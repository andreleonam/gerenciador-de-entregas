package com.premic.gerenciadorDeEntregas.resources;

import com.premic.gerenciadorDeEntregas.dto.CityDTO;
import com.premic.gerenciadorDeEntregas.dto.CityNewDTO;
import com.premic.gerenciadorDeEntregas.entities.City;
import com.premic.gerenciadorDeEntregas.resources.utils.URL;
import com.premic.gerenciadorDeEntregas.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/cities")
public class CityResource {

    @Autowired
    private CityService service;

    @GetMapping
    public ResponseEntity<List<CityDTO>> findAll() {
        List<City> list = service.findAll();
        List<CityDTO> listDto = list.stream().map(obj -> new CityDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<City> findById(@PathVariable Long id) {
        City obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<City> insert(@Valid @RequestBody CityNewDTO objDto) {
        City obj = service.fromDto(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<City> update(@PathVariable Long id, @Valid @RequestBody CityDTO objDto) {
        City obj = service.fromDto(objDto);
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/")
    public ResponseEntity<Page<CityDTO>> findPage(
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {
        String nameDecoded = URL.decodeParam(name);
        Page<City> list = service.findPage(nameDecoded, page, linesPerPage, direction, orderBy);
        Page<CityDTO> listDto = list.map(obj -> new CityDTO(obj));
        return ResponseEntity.ok().body(listDto);
    }

}