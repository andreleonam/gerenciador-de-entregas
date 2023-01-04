package com.premic.gerenciadorDeEntregas.resources;

import com.premic.gerenciadorDeEntregas.dto.UnitDTO;
import com.premic.gerenciadorDeEntregas.entities.Unit;
import com.premic.gerenciadorDeEntregas.resources.utils.URL;
import com.premic.gerenciadorDeEntregas.services.UnitService;
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
@RequestMapping(value = "/units")
public class UnitResource {

    @Autowired
    private UnitService service;

    @GetMapping
    public ResponseEntity<List<UnitDTO>> findAll() {
        List<Unit> list = service.findAll();
        List<UnitDTO> listDto = list.stream().map(obj -> new UnitDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Unit> findById(@PathVariable Long id) {
        Unit obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Unit> insert(@Valid @RequestBody UnitDTO objDto) {
        Unit obj = service.fromDto(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Unit> update(@PathVariable Long id, @Valid @RequestBody UnitDTO objDto) {
        Unit obj = service.fromDto(objDto);
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/")
    public ResponseEntity<Page<UnitDTO>> findPage(
            @RequestParam(value = "acronym", defaultValue = "") String name,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "acronym") String orderBy) {
        String nameDecoded = URL.decodeParam(name);
        Page<Unit> list = service.findPage(nameDecoded, page, linesPerPage, direction, orderBy);
        Page<UnitDTO> listDto = list.map(obj -> new UnitDTO(obj));
        return ResponseEntity.ok().body(listDto);
    }

}