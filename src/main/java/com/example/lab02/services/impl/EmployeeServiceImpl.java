package com.example.lab02.services.impl;

import com.example.lab02.models.Employee;
import com.example.lab02.repositories.EmployeeRepository;
import com.example.lab02.services.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl
extends ParentServiceImpl<Employee>
implements EmployeeService {
    private final EmployeeRepository repository;
    public EmployeeServiceImpl(){
        repository = new EmployeeRepository();
    }

    @Override
    public void deleteEmp(long id) {
        repository.deleteEmp(id);
    }

    @Override
    public List<Employee> getEmpActive() {
        return repository.getEmpActive();
    }
}
