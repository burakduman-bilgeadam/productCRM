package com.example.productCRM.serviceimp;

import com.example.productCRM.model.dto.CustomerDTO;
import com.example.productCRM.model.entity.Customer;
import com.example.productCRM.repository.CustomerRepository;
import com.example.productCRM.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
        /*CustomerDTO c = this.customerDTOList.stream()
                .filter(customer -> customer.getId()==id)
                .findFirst().orElse(null);
        customerDTOList.remove(c);
         */
    }
    @Override
    public void updateCustomer(CustomerDTO customerDTO){
        CustomerDTO cus =null;
                /*this.customerDTOList.stream()
                .filter(c -> c.getId()== customerDTO.getId())
                .findFirst().orElse(null);

                 */
        cus.setAge(customerDTO.getAge());
        cus.setName(customerDTO.getName());
        cus.setSurname(customerDTO.getSurname());
    }

    @Override
    public List<CustomerDTO> getCustomerList(){
        return this.customerDTOList;
    }
}
