package com.premic.gerenciadorDeEntregas.services;

import com.premic.gerenciadorDeEntregas.dto.CityDTO;
import com.premic.gerenciadorDeEntregas.dto.CityNewDTO;
import com.premic.gerenciadorDeEntregas.entities.City;
import com.premic.gerenciadorDeEntregas.entities.State;
import com.premic.gerenciadorDeEntregas.repositories.CityRepository;
import com.premic.gerenciadorDeEntregas.repositories.StateRepository;
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
public class CityService {

    @Autowired
    private CityRepository repository;

    @Autowired
    private StateRepository stateRepository;

    public List<City> findAll() {
        return repository.findAll();
    }

    @GetMapping
    public City findById(Long id) {
        Optional<City> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public City insert(City obj) {
        obj.setId(null);
        obj = repository.save(obj);
        return obj;
    }

    private void updateData(City entity, City obj) {
        entity.setName(obj.getName());
    }

    public City update(Long id, City obj) {
        try {
            City entity = repository.getReferenceById(id);
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

    public Page<City> findPage(String name, Integer page, Integer linesPerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findByNameContaining(name, pageRequest);
    }

    public City fromDto(CityDTO objDto) {
        return new City(objDto.getId(), objDto.getName(), null);
    }

    public City fromDto(CityNewDTO objDto) {
        State state = stateRepository.getReferenceById(objDto.getStateId());
        City city = new City(objDto.getId(), objDto.getName(), state);
        state.getCities().add(city);
        return city;
    }


}
