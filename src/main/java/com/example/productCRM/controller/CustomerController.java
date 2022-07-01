package com.example.productCRM.controller;

import com.example.productCRM.model.CustomerDTO;
import com.example.productCRM.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    //inject etmek için
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerDTO customerDTO){
        this.customerService.addCustomer(customerDTO);
        return new ResponseEntity
                ("Başarılı",HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        this.customerService.deleteCustomer(id);
        return new ResponseEntity<>
                ("Başarılı", HttpStatus.OK);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void updateCustomer(@RequestBody CustomerDTO customerDTO){
        this.customerService.updateCustomer(customerDTO);
    }
    @GetMapping
    public List<CustomerDTO> getCustomerList(){
        return this.customerService.getCustomerList();
    }
}
