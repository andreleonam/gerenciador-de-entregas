package com.premic.gerenciadorDeEntregas.repositories;

import com.premic.gerenciadorDeEntregas.entities.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CityRepository extends JpaRepository<City, Long> {

    @Transactional(readOnly = true)
    Page<City> findByNameContaining(String name, Pageable pageRequest);

}
