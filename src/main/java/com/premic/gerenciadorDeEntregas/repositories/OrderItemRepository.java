package com.premic.gerenciadorDeEntregas.repositories;

import com.premic.gerenciadorDeEntregas.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {


}
