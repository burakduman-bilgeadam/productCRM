package com.example.productCRM.serviceimp;

import com.example.productCRM.model.dto.CustomerAgeDTO;
import com.example.productCRM.model.dto.CustomerDTO;
import com.example.productCRM.model.entity.Customer;
import com.example.productCRM.repository.CustomerRepository;
import com.example.productCRM.service.CustomerService;
import com.example.productCRM.utils.ModelMapperUtil;
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
        /*
        ID olmasına rağmen güncellemezse?
        Repository e gidip id ye göre filtre çekip
        Datayı alıp ön yüzden gelen datalarla setleyip
        tekrar kaydetme yapmınız gerekiyor.
        */
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
        return this.modelMapperUtil.mapAll(
                (List<Customer>)this.customerRepository.findAll(),
                CustomerDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
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
    @Transactional(readOnly = true)
    public long getAllCountInCustomer() {
        return this.customerRepository.findCountWithoutHql();
    }

    @Override
    @Transactional
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

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDTO> getCustomerByName(String name){
        return modelMapperUtil.mapAll(
                this.customerRepository.findByName(name),CustomerDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDTO> getCustomerByNameOrSurname(String name, String surname) {
        return modelMapperUtil.mapAll(
                this.customerRepository.findByNameOrSurname(name,surname),
                CustomerDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDTO> getDistinctCustomerByName(String name) {
        return this.modelMapperUtil.mapAll(
                this.customerRepository.findDistinctByName(name),CustomerDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDTO> getGreaterThan40() {
        return this.modelMapperUtil.mapAll(
                this.customerRepository.findByAgeGreaterThan(40),
                CustomerDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDTO> getByAgeLessThanEqualAndNameIgnoreCase() {
        return this.modelMapperUtil.mapAll(this.customerRepository
                .findByAgeLessThanEqualAndNameIgnoreCase(40,"can"),
                CustomerDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDTO> getAllCustomerOrderByNameDesc() {
        return this.modelMapperUtil.mapAll(
                this.customerRepository.findAllByAgeGreaterThanOrderByName(-1),
                CustomerDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDTO> getByAgeBetweenOrNameContainingIgnoreCase() {
        return this.modelMapperUtil.mapAll(this.customerRepository
                .findByAgeBetweenAndNameContainingIgnoreCase
                        (30,50,"bur"),CustomerDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDTO> getAllCustomer() {
        return this.modelMapperUtil.mapAll(
                this.customerRepository.findAllByOrderByNameDesc(),
                CustomerDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDTO> getNameOrSurnameForCustomer(String name, String surname) {
        return this.modelMapperUtil.mapAll(
                this.customerRepository.customByNameOrSurname(name,surname),
                CustomerDTO.class);
    }

    @Override
    public List<CustomerDTO>
    getCustomersByNameOrSurname(String name, String surname) {
        return this.modelMapperUtil.mapAll(this.customerRepository.findByNameContainingIgnoreCaseOrSurnameContainingIgnoreCase
                (name,surname),CustomerDTO.class);
    }

    @Override
    public List<CustomerDTO> getCustomersByAge(Integer start_age, Integer end_age) {
        return  this.modelMapperUtil.mapAll(
                customerRepository.findByAgeBetween(start_age+1,end_age-1),CustomerDTO.class);
    }

    @Override
    public List<CustomerDTO> getCustomersFilterByName(String name) {
        return this.modelMapperUtil.mapAll(
                this.customerRepository.findByNameContainingIgnoreCaseOrderByNameDesc(name),
                CustomerDTO.class);
    }

    @Override
    public List<CustomerAgeDTO> groupByAge() {
        return this.customerRepository.findGroupByAge();
    }

    @Override
    public List<Object> groupByAgeFilterByNameWithHql(String name) {
        return customerRepository.groupByAgeFilterByNameWithoutHql
                ('%'+name+'%');
    }
}
