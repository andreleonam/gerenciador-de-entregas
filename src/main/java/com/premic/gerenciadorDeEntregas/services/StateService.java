package com.premic.gerenciadorDeEntregas.services;

import com.premic.gerenciadorDeEntregas.dto.StateDTO;
import com.premic.gerenciadorDeEntregas.entities.State;
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
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    @Autowired
    private StateRepository repository;

    public List<State> findAll() {
        return repository.findAll();
    }

    @GetMapping
    public State findById(Long id) {
        Optional<State> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public State insert(State obj) {
        return repository.save(obj);
    }

    private void updateData(State entity, State obj) {
        entity.setName(obj.getName());
        entity.setAcronym(obj.getAcronym());
    }

    public State update(Long id, State obj) {
        try {
            State entity = repository.getReferenceById(id);
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

    public Page<State> findPage(String name, Integer page, Integer linesPerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findByNameContaining(name, pageRequest);
    }

    public State fromDto(StateDTO objDto) {
        return new State(objDto.getId(), objDto.getAcronym(), objDto.getName());
    }

}
