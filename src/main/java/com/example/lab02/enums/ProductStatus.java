package com.example.lab02.enums;

import lombok.Getter;

@Getter
public enum ProductStatus {
    IN_ACTIVE(-1),
    ACTIVE(1),
    TERMINATE(0);
    private int value;
    ProductStatus(int value){
        this.value = value;
    }

}
