package com.example.lab02.backend.services;

import com.example.lab02.backend.models.Customer;

import java.util.List;

public interface CustomerService extends ParentService<Customer> {
    void deleteCustomer(long id);
    List<Customer> getCustomersActive();
}
