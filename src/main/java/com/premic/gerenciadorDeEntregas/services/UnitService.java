package com.premic.gerenciadorDeEntregas.services;

import com.premic.gerenciadorDeEntregas.dto.UnitDTO;
import com.premic.gerenciadorDeEntregas.entities.Unit;
import com.premic.gerenciadorDeEntregas.repositories.UnitRepository;
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
public class UnitService {

    @Autowired
    private UnitRepository repository;

    public List<Unit> findAll() {
        return repository.findAll();
    }

    @GetMapping
    public Unit findById(Long id) {
        Optional<Unit> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Unit insert(Unit obj) {
        return repository.save(obj);
    }

    private void updateData(Unit entity, Unit obj) {
        entity.setAcronym(obj.getAcronym());
        entity.setMeasure(obj.getMeasure());
    }

    public Unit update(Long id, Unit obj) {
        try {
            Unit entity = repository.getReferenceById(id);
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

    public Page<Unit> findPage(String name, Integer page, Integer linesPerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findByAcronymContaining(name, pageRequest);
    }

    public Unit fromDto(UnitDTO objDto) {
        return new Unit(objDto.getId(), objDto.getAcronym(), objDto.getMeasure());
    }

}
