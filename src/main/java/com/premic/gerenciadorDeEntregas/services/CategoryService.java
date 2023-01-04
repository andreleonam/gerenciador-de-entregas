package com.premic.gerenciadorDeEntregas.services;

import com.premic.gerenciadorDeEntregas.dto.CategoryDTO;
import com.premic.gerenciadorDeEntregas.entities.Category;
import com.premic.gerenciadorDeEntregas.repositories.CategoryRepository;
import com.premic.gerenciadorDeEntregas.services.exceptions.DataIntegrityException;
import com.premic.gerenciadorDeEntregas.services.exceptions.ResourceNotFoundException;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    @GetMapping
    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Category insert(Category obj) {
        return repository.save(obj);
    }

    private void updateData(Category entity, Category obj) {
        entity.setName(obj.getName());
    }

    public Category update(Long id, Category obj) {
        try {
            Category entity = repository.getReferenceById(id);
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

    public Page<Category> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public Category fromDto(CategoryDTO objDto) {
        return new Category(objDto.getId(), objDto.getNome());
    }

}
