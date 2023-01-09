package com.premic.gerenciadorDeEntregas.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.premic.gerenciadorDeEntregas.entities.enums.GoodsReceiptType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_goodsreceipt")
public class GoodsReceipt implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant dateReceipt;

    private Integer goodsReceiptType;

    private String note;

    @OneToMany(mappedBy = "id.goodsReceipt")
    private Set<ReceiptItem> receiptItems = new HashSet<>();

    public GoodsReceipt() {
    }

    public GoodsReceipt(Long id, Instant dateReceipt, GoodsReceiptType goodsReceiptType, String note) {
        this.id = id;
        this.dateReceipt = dateReceipt;
        this.goodsReceiptType = (goodsReceiptType == null) ? null : goodsReceiptType.getCode();
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDateReceipt() {
        return dateReceipt;
    }

    public void setDateReceipt(Instant dateReceipt) {
        this.dateReceipt = dateReceipt;
    }

    public GoodsReceiptType getGoodsReceiptType() {
        return GoodsReceiptType.valueOf(goodsReceiptType);
    }

    public void setGoodsReceiptType(GoodsReceiptType goodsReceiptType) {
        this.goodsReceiptType = goodsReceiptType.getCode();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set<ReceiptItem> getReceiptItems() {
        return receiptItems;
    }

    public void setReceiptItems(Set<ReceiptItem> receiptItems) {
        this.receiptItems = receiptItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoodsReceipt that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
