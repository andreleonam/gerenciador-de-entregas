package com.premic.gerenciadorDeEntregas.entities.enums;

public enum OrderStatus {

    PENDING(0, "PENDING"),
    DELIVERED(1, "DELIVERED"),
    CANCELED(2, "CANCELED");

    private Integer code;
    private String description;

    private OrderStatus(Integer code, String s) {
        this.code = code;
    }

    public static OrderStatus valueOf(Integer code) {
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid ShippingType code");
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}


