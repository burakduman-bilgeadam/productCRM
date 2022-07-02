package com.example.productCRM.serviceimp;

import com.example.productCRM.model.dto.CustomerDTO;
import com.example.productCRM.model.entity.Customer;
import com.example.productCRM.repository.CustomerRepository;
import com.example.productCRM.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public static List<CustomerDTO> customerDTOList =new ArrayList<>();
    @Override
    public void addCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setAge(customerDTO.getAge());
        customer.setName(customerDTO.getName());
        customer.setSurname(customerDTO.getSurname());
        customer.setInsertDate(new Date());
        customerRepository.save(customer);
    }
    @Override
    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
    @Override
    public void updateCustomer(CustomerDTO customerDTO){
        //TODO: ilk kayıtı bulalım
        Customer customer = new Customer();
        customer.setAge(customerDTO.getAge());
        customer.setName(customerDTO.getName());
        customer.setSurname(customerDTO.getSurname());
        customer.setId(customerDTO.getId());
        customerRepository.save(customer);
    }

    @Override
    public List<CustomerDTO> getCustomerList(){
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        Iterator<Customer> customerIterator=
                customerRepository.findAll().iterator();
        while(customerIterator.hasNext()){
            CustomerDTO customerDTO = new CustomerDTO();
            Customer customer = customerIterator.next();
            customerDTO.setAge(customer.getAge());
            customerDTO.setName(customer.getName());
            customerDTO.setSurname(customer.getSurname());
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }
}
