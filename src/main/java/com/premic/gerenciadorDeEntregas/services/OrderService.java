package com.premic.gerenciadorDeEntregas.services;

import com.premic.gerenciadorDeEntregas.entities.Order;
import com.premic.gerenciadorDeEntregas.entities.OrderItem;
import com.premic.gerenciadorDeEntregas.entities.enums.OrderStatus;
import com.premic.gerenciadorDeEntregas.repositories.OrderItemRepository;
import com.premic.gerenciadorDeEntregas.repositories.OrderRepository;
import com.premic.gerenciadorDeEntregas.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

import static java.time.Instant.now;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private ProductService productService;

    public List<Order> findAll() {
        return repository.findAll();
    }

    @GetMapping
    public Order findById(Long id) {
        Optional<Order> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public Order insert(Order obj) {
        obj.setId(null);
        obj.setOrderDate(now());
        obj.setOrderStatus(OrderStatus.PENDING);
        obj.setCustomer(customerService.findById(obj.getCustomer().getId()));
        obj.setDeliveryAddress(addressService.findById(obj.getDeliveryAddress().getId()));
        repository.save(obj);

        for (OrderItem item : obj.getOrderItems()) {
            item.setOrder(obj);
            // item.setProduct(obj.ge);
        }
        orderItemRepository.saveAll(obj.getOrderItems());
        repository.save(obj);
        return obj;
    }
}
