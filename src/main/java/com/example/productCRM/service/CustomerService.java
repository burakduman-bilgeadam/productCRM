package com.example.productCRM.service;

import com.example.productCRM.model.dto.CustomerDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    void addCustomer(CustomerDTO customerDTO);
    void updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(Long id);
    List<CustomerDTO> getCustomerList();

    ResponseEntity<CustomerDTO> getCustomerById(Long id);

    long getAllCountInCustomer();
    void addListCustomer(List<CustomerDTO> customerDTOList);
 }
