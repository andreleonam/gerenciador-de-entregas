package com.premic.gerenciadorDeEntregas.resources;

import com.premic.gerenciadorDeEntregas.dto.PublicPlaceDTO;
import com.premic.gerenciadorDeEntregas.entities.PublicPlace;
import com.premic.gerenciadorDeEntregas.resources.utils.URL;
import com.premic.gerenciadorDeEntregas.services.PublicPlaceService;
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
@RequestMapping(value = "/publicplaces")
public class PublicPlaceResource {

    @Autowired
    private PublicPlaceService service;

    @GetMapping
    public ResponseEntity<List<PublicPlaceDTO>> findAll() {
        List<PublicPlace> list = service.findAll();
        List<PublicPlaceDTO> listDto = list.stream().map(obj -> new PublicPlaceDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PublicPlace> findById(@PathVariable Long id) {
        PublicPlace obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<PublicPlace> insert(@Valid @RequestBody PublicPlaceDTO objDto) {
        PublicPlace obj = service.fromDto(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PublicPlace> update(@PathVariable Long id, @Valid @RequestBody PublicPlaceDTO objDto) {
        PublicPlace obj = service.fromDto(objDto);
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/")
    public ResponseEntity<Page<PublicPlaceDTO>> findPage(
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {
        String nameDecoded = URL.decodeParam(name);
        Page<PublicPlace> list = service.findPage(nameDecoded, page, linesPerPage, direction, orderBy);
        Page<PublicPlaceDTO> listDto = list.map(obj -> new PublicPlaceDTO(obj));
        return ResponseEntity.ok().body(listDto);
    }

}