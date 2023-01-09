package com.premic.gerenciadorDeEntregas.services;

import com.premic.gerenciadorDeEntregas.entities.*;
import com.premic.gerenciadorDeEntregas.entities.enums.GoodsReceiptType;
import com.premic.gerenciadorDeEntregas.entities.enums.OrderStatus;
import com.premic.gerenciadorDeEntregas.entities.enums.ShippingType;
import com.premic.gerenciadorDeEntregas.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Arrays;

@Service
public class DBService {


    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    GoodsReceiptRepository goodsReceiptRepository;

    @Autowired
    ReceiptItemRepository receiptItemRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    OrderRepository orderRepository;


    public void instantiateTestDatabase() {

        Customer customer01 = new Customer(null, "Andre Costa", "andreleonam@gmail.com");
        customer01.getPhones().addAll(Arrays.asList("79999363370", "7932413900"));
        Address address01 = new Address(null, "AV SAO JOAO BATISTA", "638", "BL01 AP203", "PONTO NOVO", "49097000", "ARACAJU", "SERGIPE", customer01);
        Address address02 = new Address(null, "RUA ASTROGESILO SANTANA S FILHO", "15", "CONJUNTO COSTA E SILVA", "SIQUEIRA CAMPOS", "49082110", "ARACAJU", "SERGIPE", customer01);
        customer01.getAddresses().add(address01);
        customer01.getAddresses().add(address02);
        customerRepository.saveAll(Arrays.asList(customer01));
        addressRepository.saveAll(Arrays.asList(address01, address02));

        Product p01 = new Product(null, "VIGA TRELICA 100CM", "PÇ");
        Product p02 = new Product(null, "CIMENTO 50KG", "SC");
        Product p03 = new Product(null, "LAJOTA EPS ESPESSURA 8CM", "M3");
        Product p04 = new Product(null, "ESTACA CONC ARM PVT 330CM", "PÇ");
        Product p05 = new Product(null, "ESTACA CONC ARM RQ 250CM", "PÇ");
        Product p06 = new Product(null, "PLACA CONC ARM ESPESSURA: 8CM", "M2");
        productRepository.saveAll(Arrays.asList(p01, p02, p03, p04, p05, p06));

        GoodsReceipt gr01 = new GoodsReceipt(null, Instant.parse("2017-09-30T10:32:00Z"), GoodsReceiptType.MANUFACTURING, "");
        GoodsReceipt gr02 = new GoodsReceipt(null, Instant.parse("2017-10-10T19:35:00Z"), GoodsReceiptType.ACQUISITION, "");
        // goodsReceiptRepository.saveAll(Arrays.asList(gr01, gr02));

        ReceiptItem ri01 = new ReceiptItem(gr01, p01, 10.0);
        ReceiptItem ri02 = new ReceiptItem(gr01, p04, 20.0);
        ReceiptItem ri03 = new ReceiptItem(gr01, p05, 30.0);
        ReceiptItem ri04 = new ReceiptItem(gr01, p06, 40.0);
        ReceiptItem ri05 = new ReceiptItem(gr02, p02, 100.0);
        ReceiptItem ri06 = new ReceiptItem(gr02, p03, 200.0);

        gr01.getReceiptItems().addAll(Arrays.asList(ri01, ri02, ri03, ri04));
        gr02.getReceiptItems().addAll(Arrays.asList(ri05, ri06));

        p01.getReceiptItems().add(ri01);
        p02.getReceiptItems().add(ri05);
        p03.getReceiptItems().add(ri06);
        p04.getReceiptItems().add(ri02);
        p05.getReceiptItems().add(ri03);
        p06.getReceiptItems().add(ri04);

        goodsReceiptRepository.saveAll(Arrays.asList(gr01, gr02));
        receiptItemRepository.saveAll(Arrays.asList(ri01, ri02, ri03, ri04, ri05, ri06));

        Order order01 = new Order(null, Instant.now(), Instant.parse("2023-01-20T06:00:00Z"), ShippingType.CIF, OrderStatus.PENDING, "entregar em horario comercial", customer01, address01);
        Order order02 = new Order(null, Instant.now(), Instant.parse("2023-01-25T06:00:00Z"), ShippingType.FOB, OrderStatus.PENDING, null, customer01, address02);

        OrderItem oi01 = new OrderItem(order01, p01, 10.0);
        OrderItem oi02 = new OrderItem(order01, p04, 20.0);
        OrderItem oi03 = new OrderItem(order01, p05, 30.0);
        OrderItem oi04 = new OrderItem(order01, p06, 40.0);
        OrderItem oi05 = new OrderItem(order02, p02, 100.0);
        OrderItem oi06 = new OrderItem(order02, p03, 200.0);

        p01.getOrderItems().add(oi01);
        p02.getOrderItems().add(oi05);
        p03.getOrderItems().add(oi06);
        p04.getOrderItems().add(oi02);
        p05.getOrderItems().add(oi03);
        p06.getOrderItems().add(oi04);

        orderRepository.saveAll(Arrays.asList(order01, order02));
        orderItemRepository.saveAll(Arrays.asList(oi01, oi02, oi03, oi04, oi05, oi06));
    }
}