package com.premic.gerenciadorDeEntregas.entities.enums;

public enum GoodsReceiptType {

    ACQUISITION(1, "ACQUISITION"),
    MANUFACTURING(2, "MANUFACTURING"),
    GOODS_RETURN(3, "GOODS RETURN");

    private Integer code;
    private String description;

    private GoodsReceiptType(Integer code, String s) {
        this.code = code;
    }

    public static GoodsReceiptType valueOf(Integer code) {
        for (GoodsReceiptType value : GoodsReceiptType.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid GoodsReceiptType code");
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}


