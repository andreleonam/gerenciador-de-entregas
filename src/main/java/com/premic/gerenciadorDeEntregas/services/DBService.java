package com.premic.gerenciadorDeEntregas.services;

import com.premic.gerenciadorDeEntregas.entities.Category;
import com.premic.gerenciadorDeEntregas.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void instantiateTestDatabase() {

        Category cat1 = new Category(null, "TRELICA");
        Category cat2 = new Category(null, "ESTACA");
        Category cat3 = new Category(null, "TUBO");
        Category cat4 = new Category(null, "PISO");
        Category cat5 = new Category(null, "LAJOTA");
        Category cat6 = new Category(null, "PLACA");
        Category cat7 = new Category(null, "COBOGO");
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
    }
}