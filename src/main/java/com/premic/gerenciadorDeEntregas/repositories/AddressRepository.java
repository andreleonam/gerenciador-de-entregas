package com.premic.gerenciadorDeEntregas.repositories;

import com.premic.gerenciadorDeEntregas.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {


}
