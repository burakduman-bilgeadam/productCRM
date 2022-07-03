package com.example.productCRM.repository;

import com.example.productCRM.model.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository
        extends CrudRepository<Customer,Long> {
    List<Customer> findByName(String name);
}
