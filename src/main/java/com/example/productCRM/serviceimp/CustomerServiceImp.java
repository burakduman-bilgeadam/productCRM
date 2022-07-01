package com.example.productCRM.serviceimp;

import com.example.productCRM.model.CustomerDTO;
import com.example.productCRM.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    public static List<CustomerDTO> customerDTOList =new ArrayList<>();
    @Override
    public void addCustomer(CustomerDTO customerDTO){
        this.customerDTOList.add(customerDTO);
    }
    @Override
    public void deleteCustomer(Long id){
        CustomerDTO c = this.customerDTOList.stream()
                .filter(customer -> customer.getId()==id)
                .findFirst().orElse(null);
        customerDTOList.remove(c);
    }
    @Override
    public void updateCustomer(CustomerDTO customerDTO){
        CustomerDTO cus = this.customerDTOList.stream()
                .filter(c -> c.getId()== customerDTO.getId())
                .findFirst().orElse(null);
        cus.setAge(customerDTO.getAge());
        cus.setName(customerDTO.getName());
        cus.setSurname(customerDTO.getSurname());
    }

    @Override
    public List<CustomerDTO> getCustomerList(){
        return this.customerDTOList;
    }
}
