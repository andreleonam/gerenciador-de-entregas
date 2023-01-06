package com.premic.gerenciadorDeEntregas.repositories;

import com.premic.gerenciadorDeEntregas.entities.PublicPlace;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


public interface PublicPlaceRepository extends JpaRepository<PublicPlace, Long> {

    @Transactional(readOnly = true)
    Page<PublicPlace> findByNameContaining(String name, Pageable pageRequest);

}
