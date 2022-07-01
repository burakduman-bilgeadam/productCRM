package com.example.productCRM.service;

import com.example.productCRM.model.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void addCustomer(CustomerDTO customerDTO);
    void updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(Long id);
    List<CustomerDTO> getCustomerList();
 }
