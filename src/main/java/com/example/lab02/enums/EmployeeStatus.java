package com.example.lab02.enums;


public enum EmployeeStatus {
    TEMINATE(-1),
    ACTIVE(1),
    IN_ACTIVE(1);
    private int value;
    EmployeeStatus(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
