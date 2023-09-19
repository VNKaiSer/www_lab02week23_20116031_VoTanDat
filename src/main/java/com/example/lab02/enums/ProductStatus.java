package com.example.lab02.enums;

public enum ProductStatus {
    BUSSINESS(1),
    PAUSE(0),
    NOT_BUSSINESS(-1);
    private int value;
    ProductStatus(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
