package com.premic.gerenciadorDeEntregas.repositories;

import com.premic.gerenciadorDeEntregas.entities.Category;
import com.premic.gerenciadorDeEntregas.entities.Unit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UnitRepository extends JpaRepository<Unit, Long> {

    @Transactional(readOnly = true)
    Page<Unit> findByAcronymContaining(String name, Pageable pageRequest);

}
