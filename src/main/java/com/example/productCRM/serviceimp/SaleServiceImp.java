package com.example.productCRM.serviceimp;

import com.example.productCRM.model.CustomerDTO;
import com.example.productCRM.model.ProductDTO;
import com.example.productCRM.model.SaleDTO;
import com.example.productCRM.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleServiceImp implements SaleService {
    @Autowired
    private CustomerServiceImp customerService;
    @Autowired
    private ProductServiceImp productService;

    private List<SaleDTO> saleDTOS = new ArrayList<>();

    @Override
    public void addSale(Long customerId, Long productId,Long saleId) {
        CustomerDTO c = this.customerService
                .getCustomerList().stream()
                .filter(customer -> customer.getId() == customerId)
                .findFirst().orElse(null);

        ProductDTO p = this.productService.getProductList().stream()
                .filter(product -> product.getId() == productId)
                .findFirst().orElse(null);
        SaleDTO s = new SaleDTO(saleId,p,c);
        this.saleDTOS.add(s);
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
    public void updateSale(Long customerId, Long productId,Long saleId) {
        CustomerDTO c = this.customerService
                .getCustomerList().stream()
                .filter(customer -> customer.getId() == customerId)
                .findFirst().orElse(null);

        ProductDTO p = this.productService.getProductList().stream()
                .filter(product -> product.getId() == productId)
                .findFirst().orElse(null);

        SaleDTO s = this.saleDTOS.stream()
                .filter(saleDTO -> saleDTO.getId() == saleId)
                .findFirst().orElse(null);
        if(s!=null){
            s.setCustomer(c);
            s.setProduct(p);
        }
    }

    @Override
    public List<SaleDTO> getSales() {
        return this.saleDTOS;
    }
}
