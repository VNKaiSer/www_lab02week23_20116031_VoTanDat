package com.example.lab02.services;

import com.example.lab02.models.Employee;

import java.util.List;

public interface EmployeeService extends ParentService<Employee> {
    void deleteEmp(long id);
    List<Employee> getEmpActive();
}
