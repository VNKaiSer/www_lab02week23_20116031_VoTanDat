package com.example.lab02.backend.services.impl;

import com.example.lab02.backend.models.Employee;
import com.example.lab02.backend.repositories.EmployeeRepository;
import com.example.lab02.backend.services.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl
extends ParentServiceImpl<Employee>
implements EmployeeService {
    private final EmployeeRepository repository;
    public EmployeeServiceImpl(){
        super();
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
