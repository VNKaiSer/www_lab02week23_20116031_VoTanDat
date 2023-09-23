package com.example.lab02.services.impl;

import com.example.lab02.models.Customer;
import com.example.lab02.repositories.CustomerRepository;
import com.example.lab02.services.CustomerService;

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
