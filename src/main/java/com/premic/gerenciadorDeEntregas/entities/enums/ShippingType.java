package com.premic.gerenciadorDeEntregas.entities.enums;

public enum ShippingType {

    CIF(0, "CIF"),
    FOB(1, "FOB");

    private Integer code;
    private String description;

    private ShippingType(Integer code, String s) {
        this.code = code;
    }

    public static ShippingType valueOf(Integer code) {
        for (ShippingType value : ShippingType.values()) {
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


