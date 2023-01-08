package com.premic.gerenciadorDeEntregas.repositories;

import com.premic.gerenciadorDeEntregas.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {


}
