package com.premic.gerenciadorDeEntregas.resources;

import com.premic.gerenciadorDeEntregas.dto.CustomerDTO;
import com.premic.gerenciadorDeEntregas.entities.Customer;
import com.premic.gerenciadorDeEntregas.resources.utils.URL;
import com.premic.gerenciadorDeEntregas.services.CustomerService;
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
@RequestMapping(value = "/customers")
public class CustomerResource {

    @Autowired
    private CustomerService service;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAll() {
        List<Customer> list = service.findAll();
        List<CustomerDTO> listDto = list.stream().map(obj -> new CustomerDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id) {
        Customer obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Customer> insert(@Valid @RequestBody CustomerDTO objDto) {
        Customer obj = service.fromDto(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @Valid @RequestBody CustomerDTO objDto) {
        Customer obj = service.fromDto(objDto);
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/")
    public ResponseEntity<Page<CustomerDTO>> findPage(
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {
        String nameDecoded = URL.decodeParam(name);
        Page<Customer> list = service.findPage(nameDecoded, page, linesPerPage, direction, orderBy);
        Page<CustomerDTO> listDto = list.map(obj -> new CustomerDTO(obj));
        return ResponseEntity.ok().body(listDto);
    }

}