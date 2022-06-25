package com.example.productCRM.controller;

import com.example.productCRM.model.Customer;
import com.example.productCRM.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    //inject etmek için
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public void addCustomer(@RequestBody Customer customer){
        this.customerService.addCustomer(customer);
    }
    @DeleteMapping
    public void deleteCustomer(){}
    @PutMapping
    public void updateCustomer(){}
    @GetMapping
    public void getCustomerList(){}
}
