package com.premic.gerenciadorDeEntregas.services;

import com.premic.gerenciadorDeEntregas.entities.Address;
import com.premic.gerenciadorDeEntregas.entities.Customer;
import com.premic.gerenciadorDeEntregas.repositories.AddressRepository;
import com.premic.gerenciadorDeEntregas.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {


    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AddressRepository addressRepository;

    public void instantiateTestDatabase() {

        Customer customer01 = new Customer(null, "Andre Costa", "andreleonam@gmail.com");
        customer01.getPhones().addAll(Arrays.asList("79999363370", "7932413900"));
        Address address01 = new Address(null, "AV SAO JOAO BATISTA", "638", "BL01 AP203", "PONTO NOVO", "49097000", "ARACAJU", "SERGIPE", customer01);
        Address address02 = new Address(null, "RUA ASTROGESILO SANTANA S FILHO", "15", "CONJUNTO COSTA E SILVA", "SIQUEIRA CAMPOS", "49082110", "ARACAJU", "SERGIPE", customer01);
        customer01.getAddresses().add(address01);
        customer01.getAddresses().add(address02);
        customerRepository.saveAll(Arrays.asList(customer01));
        addressRepository.saveAll(Arrays.asList(address01, address02));

    }
}