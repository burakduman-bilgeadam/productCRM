package com.example.productCRM.service;

import com.example.productCRM.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private List<Customer> customerList;

    public void addCustomer(Customer customer){
        this.customerList.add(customer);
    }
}
