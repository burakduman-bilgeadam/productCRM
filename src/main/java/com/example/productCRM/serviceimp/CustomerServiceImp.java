package com.example.productCRM.serviceimp;

import com.example.productCRM.model.Customer;
import com.example.productCRM.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    private List<Customer> customerList=new ArrayList<>();
    @Override
    public void addCustomer(Customer customer){
        this.customerList.add(customer);
    }
    @Override
    public void deleteCustomer(Long id){
        Customer c = this.customerList.stream()
                .filter(customer -> customer.getId()==id)
                .findFirst().orElse(null);
        customerList.remove(c);
    }
    @Override
    public void updateCustomer(Customer customer){
        Customer cus = this.customerList.stream()
                .filter(c -> c.getId()==customer.getId())
                .findFirst().orElse(null);
        cus.setAge(customer.getAge());
        cus.setName(customer.getName());
        cus.setSurname(customer.getSurname());
    }

    @Override
    public List<Customer> getCustomerList(){
        return this.customerList;
    }
}
