package com.example.lab02.backend.services;

import com.example.lab02.backend.models.Employee;

import java.util.List;

public interface EmployeeService extends ParentService<Employee> {
    void deleteEmp(long id);
    List<Employee> getEmpActive();
}
