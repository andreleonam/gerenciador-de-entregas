package com.premic.gerenciadorDeEntregas.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.premic.gerenciadorDeEntregas.entities.pk.ReceiptItemPK;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_receipt_item")
public class ReceiptItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private ReceiptItemPK id = new ReceiptItemPK();

    private Double amount;

    public ReceiptItem() {
    }

    public ReceiptItem(GoodsReceipt goodsReceipt, Product product, Double amount) {
        id.setGoodsReceipt(goodsReceipt);
        id.setProduct(product);
        this.amount = amount;
    }

    public void setGoodsReceipt(GoodsReceipt goodsReceipt){
        id.setGoodsReceipt(goodsReceipt);
    }

    @JsonIgnore
    public GoodsReceipt getGoodsReceipt(){
        return id.getGoodsReceipt();
    }

    public void setProduct(Product product){
        id.setProduct(product);
    }

    public Product getProduct(){
        return id.getProduct();
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
        if (!(o instanceof ReceiptItem that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
