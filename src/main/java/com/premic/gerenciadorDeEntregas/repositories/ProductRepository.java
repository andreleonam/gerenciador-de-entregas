package com.premic.gerenciadorDeEntregas.repositories;

import com.premic.gerenciadorDeEntregas.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Transactional(readOnly = true)
    Page<Product> findByNameContaining(String name, Pageable pageRequest);


}
