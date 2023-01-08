package com.premic.gerenciadorDeEntregas.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.premic.gerenciadorDeEntregas.entities.pk.OrderItemPK;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private Double amount;

    public OrderItem() {
    }

    public OrderItem(Order order, Product product, Double amount) {
        id.setOrder(order);
        id.setProduct(product);
        this.amount = amount;
    }

    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }


    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
