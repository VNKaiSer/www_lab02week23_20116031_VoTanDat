package com.example.lab02.test;
import com.example.lab02.backend.enums.EmployeeStatus;
import com.example.lab02.backend.models.Employee;
import com.example.lab02.backend.repositories.instance.DBInstance;

import java.time.LocalDate;
public class TestApp {
    public static void main(String[] args) {
        DBInstance.getInstance().getEntityManager();
    }
}
