package com.example.lab02.backend.services.impl;

import com.example.lab02.backend.models.Customer;
import com.example.lab02.backend.repositories.CustomerRepository;
import com.example.lab02.backend.services.CustomerService;

import java.util.List;

public class CustomerServiceImpl
extends ParentServiceImpl<Customer>
implements CustomerService {
    private final CustomerRepository repository;
    public CustomerServiceImpl() {
        super();
        repository = new CustomerRepository();
    }


    @Override
    public void deleteCustomer(long id) {
        repository.deleteCustomer(id);
    }

    @Override
    public List<Customer> getCustomersActive() {
        return repository.getCustomersActive();
    }
}
