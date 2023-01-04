package com.premic.gerenciadorDeEntregas.resources;

import com.premic.gerenciadorDeEntregas.dto.CategoryDTO;
import com.premic.gerenciadorDeEntregas.entities.Category;
import com.premic.gerenciadorDeEntregas.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() {
        List<Category> list = service.findAll();
        List<CategoryDTO> listDto = list.stream().map(obj -> new CategoryDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}