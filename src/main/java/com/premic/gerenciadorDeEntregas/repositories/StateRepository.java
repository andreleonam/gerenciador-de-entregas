package com.premic.gerenciadorDeEntregas.repositories;

import com.premic.gerenciadorDeEntregas.entities.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface StateRepository extends JpaRepository<State, Long> {

    @Transactional(readOnly = true)
    Page<State> findByNameContaining(String name, Pageable pageRequest);

}
