package com.premic.gerenciadorDeEntregas.services;

import com.premic.gerenciadorDeEntregas.entities.Address;
import com.premic.gerenciadorDeEntregas.repositories.AddressRepository;
import com.premic.gerenciadorDeEntregas.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public List<Address> findAll() {
        return repository.findAll();
    }

    @GetMapping
    public Address findById(Long id) {
        Optional<Address> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

}
