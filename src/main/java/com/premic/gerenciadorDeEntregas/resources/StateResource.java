package com.premic.gerenciadorDeEntregas.resources;

import com.premic.gerenciadorDeEntregas.dto.StateDTO;
import com.premic.gerenciadorDeEntregas.entities.State;
import com.premic.gerenciadorDeEntregas.resources.utils.URL;
import com.premic.gerenciadorDeEntregas.services.StateService;
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
@RequestMapping(value = "/states")
public class StateResource {

    @Autowired
    private StateService service;

    @GetMapping
    public ResponseEntity<List<StateDTO>> findAll() {
        List<State> list = service.findAll();
        List<StateDTO> listDto = list.stream().map(obj -> new StateDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<State> findById(@PathVariable Long id) {
        State obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<State> insert(@Valid @RequestBody StateDTO objDto) {
        State obj = service.fromDto(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<State> update(@PathVariable Long id, @Valid @RequestBody StateDTO objDto) {
        State obj = service.fromDto(objDto);
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/")
    public ResponseEntity<Page<StateDTO>> findPage(
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {
        String nameDecoded = URL.decodeParam(name);
        Page<State> list = service.findPage(nameDecoded, page, linesPerPage, direction, orderBy);
        Page<StateDTO> listDto = list.map(obj -> new StateDTO(obj));
        return ResponseEntity.ok().body(listDto);
    }

}