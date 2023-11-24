package com.example.lab02.backend.enums;


import lombok.Getter;

@Getter
public enum EmployeeStatus {
    TERMINATE(-1),
    ACTIVE(1),
    IN_ACTIVE(1);
    private final int value;
    EmployeeStatus(int value){
        this.value = value;
    }

}
