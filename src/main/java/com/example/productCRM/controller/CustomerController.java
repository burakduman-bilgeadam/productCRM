package com.example.productCRM.controller;

import com.example.productCRM.model.dto.CustomerDTO;
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

    /*
    [
    {
    "name":"Can",
    "surname":"Kemal",
    "age":40
    },{
    "name":"Can",
    "surname":"Kemal",
    "age":40
},{
    "name":"Can",
    "surname":"Kemal",
    "age":40
},{
    "name":"Can",
    "surname":"Kemal",
    "age":40
}
]
     */
    // customer veya product toplu kayıt ekleme endpointi yazılacak.
    @PostMapping("addList")
    public ResponseEntity addListCustomer(@RequestBody List<CustomerDTO>
                                                  customerDTOList){
        this.customerService.addListCustomer(customerDTOList);
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

    // id ye göre customer veya product sorgulama
    // eğer id yanlış girilmişse bu kayıt yoksa
    // hata dönmenizi istiyorum.
    @GetMapping("findById")
    public ResponseEntity<CustomerDTO> getCustomerById(@RequestParam(value = "id")
                                       Long id){
        return customerService.getCustomerById(id);
    }
    // tablodaki toplam kayıt sayısı döndüren methodları yazınız.
    @GetMapping("allCount")
    public ResponseEntity<Long> getAllCountInCustomer(){
        return new ResponseEntity<>
                (customerService.getAllCountInCustomer(),HttpStatus.OK);
    }
}
