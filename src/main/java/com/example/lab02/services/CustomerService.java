package com.example.lab02.services;

import com.example.lab02.models.Customer;

import java.util.List;

public interface CustomerService extends ParentService<Customer> {
    void deleteCustomer(long id);
    List<Customer> getCustomersActive();
}
