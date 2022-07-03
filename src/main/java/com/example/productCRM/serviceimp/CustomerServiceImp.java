package com.example.productCRM.serviceimp;

import com.example.productCRM.model.dto.CustomerDTO;
import com.example.productCRM.model.entity.Customer;
import com.example.productCRM.repository.CustomerRepository;
import com.example.productCRM.service.CustomerService;
import com.example.productCRM.service.utils.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapperUtil modelMapperUtil;
    @Override
    @Transactional
    public void addCustomer(CustomerDTO customerDTO){
        Customer customer =
                modelMapperUtil.convertToModel(customerDTO,Customer.class);
        customer.setInsertDate(new Date());
        customerRepository.save(customer);
    }
    @Override
    @Transactional
    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
    @Override
    @Transactional
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
    @Transactional(readOnly = true)
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

    @Override
    public ResponseEntity<CustomerDTO> getCustomerById(Long id) {
        Boolean isExists = this.customerRepository.existsById(id);
        if(isExists){
            Customer customer =
                    this.customerRepository.findById(id).get();
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setSurname(customer.getSurname());
            customerDTO.setName(customer.getName());
            customerDTO.setAge(customer.getAge());
            return new ResponseEntity<>(customerDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public long getAllCountInCustomer() {
        return this.customerRepository.count();
    }

    @Override
    public void addListCustomer(List<CustomerDTO> customerDTOList) {
        List<Customer> customerList = new ArrayList<>();
        for(CustomerDTO customerDTO : customerDTOList){
            Customer customer = new Customer();
            customer.setAge(customerDTO.getAge());
            customer.setSurname(customerDTO.getSurname());
            customer.setName(customerDTO.getName());
            customer.setInsertDate(new Date());
            customerList.add(customer);
        }
        this.customerRepository.saveAll(customerList);
    }


}
