package com.premic.gerenciadorDeEntregas.services;

import com.premic.gerenciadorDeEntregas.dto.PublicPlaceDTO;
import com.premic.gerenciadorDeEntregas.entities.PublicPlace;
import com.premic.gerenciadorDeEntregas.repositories.PublicPlaceRepository;
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
public class PublicPlaceService {

    @Autowired
    private PublicPlaceRepository repository;

    public List<PublicPlace> findAll() {
        return repository.findAll();
    }

    @GetMapping
    public PublicPlace findById(Long id) {
        Optional<PublicPlace> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public PublicPlace insert(PublicPlace obj) {
        return repository.save(obj);
    }

    private void updateData(PublicPlace entity, PublicPlace obj) {
        entity.setAcronym(obj.getAcronym());
        entity.setName(obj.getName());
    }

    public PublicPlace update(Long id, PublicPlace obj) {
        try {
            PublicPlace entity = repository.getReferenceById(id);
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

    public Page<PublicPlace> findPage(String name, Integer page, Integer linesPerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findByNameContaining(name, pageRequest);
    }

    public PublicPlace fromDto(PublicPlaceDTO objDto) {
        return new PublicPlace(objDto.getId(), objDto.getAcronym(), objDto.getName());
    }

}
