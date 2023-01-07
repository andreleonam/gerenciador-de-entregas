package com.premic.gerenciadorDeEntregas.resources;

import com.premic.gerenciadorDeEntregas.entities.Address;
import com.premic.gerenciadorDeEntregas.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/adresses")
public class AddressResource {

    @Autowired
    private AddressService service;

    @GetMapping
    public ResponseEntity<List<Address>> findAll() {
        List<Address> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Address> findById(@PathVariable Long id) {
        Address obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}