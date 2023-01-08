package com.premic.gerenciadorDeEntregas.services;

import com.premic.gerenciadorDeEntregas.dto.CustomerDTO;
import com.premic.gerenciadorDeEntregas.dto.CustomerNewDTO;
import com.premic.gerenciadorDeEntregas.entities.Address;
import com.premic.gerenciadorDeEntregas.entities.Customer;
import com.premic.gerenciadorDeEntregas.repositories.AddressRepository;
import com.premic.gerenciadorDeEntregas.repositories.CustomerRepository;
import com.premic.gerenciadorDeEntregas.services.exceptions.DataIntegrityException;
import com.premic.gerenciadorDeEntregas.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private AddressRepository addressRepository;


    public List<Customer> findAll() {
        return repository.findAll();
    }

    @GetMapping
    public Customer findById(Long id) {
        Optional<Customer> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public Customer insert(Customer obj) {
        obj.setId(null);
        obj = repository.save(obj);
        return obj;
    }

    private void updateData(Customer entity, Customer obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
    }

    public Customer update(Long id, Customer obj) {
        try {
            Customer entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Exclude is not possible");
        }

    }

    public Page<Customer> findPage(String name, Integer page, Integer linesPerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findByNameContaining(name, pageRequest);
    }

    public Customer fromDto(CustomerDTO objDto) {
        return new Customer(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

    public Customer fromDto(CustomerNewDTO objDto) {
        Customer customer = new Customer(null, objDto.getName(), objDto.getEmail());
        Address address = new Address(null, objDto.getStreet(), objDto.getNumber(), objDto.getComplement(), objDto.getDistrict(), objDto.getZipCode(), objDto.getCity(), objDto.getState(), customer);
        customer.getAddresses().add(address);
        customer.getPhones().add(objDto.getPhoneNumber01());
        if (objDto.getPhoneNumber02() != null) {
            customer.getPhones().add(objDto.getPhoneNumber02());
        }
        if (objDto.getPhoneNumber03() != null) {
            customer.getPhones().add(objDto.getPhoneNumber03());
        }
        return customer;
    }
}
