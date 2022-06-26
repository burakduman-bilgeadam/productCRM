package com.example.productCRM.service;

import com.example.productCRM.model.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(Long id);
    List<Customer> getCustomerList();
 }
