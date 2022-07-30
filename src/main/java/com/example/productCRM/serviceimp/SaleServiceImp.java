package com.example.productCRM.serviceimp;

import com.example.productCRM.model.dto.CustomerDTO;
import com.example.productCRM.model.dto.ProductDTO;
import com.example.productCRM.model.dto.SaleDTO;
import com.example.productCRM.model.entity.Customer;
import com.example.productCRM.model.entity.Product;
import com.example.productCRM.model.entity.Sale;
import com.example.productCRM.repository.CustomerRepository;
import com.example.productCRM.repository.ProductRepository;
import com.example.productCRM.repository.SaleRepository;
import com.example.productCRM.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleServiceImp implements SaleService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SaleRepository saleRepository;

    private List<SaleDTO> saleDTOS = new ArrayList<>();

    @Transactional
    @Override
    public void addSale(Long customerId, List<Long> productId,Long saleId) {
        Sale sale = new Sale();
        Customer customer = customerRepository
                .findById(customerId).orElse(null);
        sale.setCustomer(customer);
        List<Product> products = (List<Product>) productRepository
                .findAllById(productId);
        sale.setProducts(products);
        saleRepository.save(sale);

    }

    @Override
    public void deleteSale(Long id) {
        SaleDTO s = this.saleDTOS.stream()
                .filter(saleDTO -> saleDTO.getId() == id)
                .findFirst().orElse(null);
        if(s!=null){
            this.saleDTOS.remove(s);
        }
    }

    @Override
    public void updateSale(Long customerId, List<Long> productId,Long saleId) {

    }

    @Override
    public List<SaleDTO> getSales() {
        return this.saleDTOS;
    }
}
