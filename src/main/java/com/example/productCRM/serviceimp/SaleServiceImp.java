package com.example.productCRM.serviceimp;

import com.example.productCRM.model.Customer;
import com.example.productCRM.model.Product;
import com.example.productCRM.model.Sale;
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

    private List<Sale> sales = new ArrayList<>();

    @Override
    public void addSale(Long customerId, Long productId,Long saleId) {
        Customer c = this.customerService
                .getCustomerList().stream()
                .filter(customer -> customer.getId() == customerId)
                .findFirst().orElse(null);

        Product p = this.productService.getProductList().stream()
                .filter(product -> product.getId() == productId)
                .findFirst().orElse(null);
        Sale s = new Sale(saleId,p,c);
        this.sales.add(s);
    }

    @Override
    public void deleteSale(Long id) {
        Sale s = this.sales.stream()
                .filter(sale -> sale.getId() == id)
                .findFirst().orElse(null);
        if(s!=null){
            this.sales.remove(s);
        }
    }

    @Override
    public void updateSale(Long customerId, Long productId,Long saleId) {
        Customer c = this.customerService
                .getCustomerList().stream()
                .filter(customer -> customer.getId() == customerId)
                .findFirst().orElse(null);

        Product p = this.productService.getProductList().stream()
                .filter(product -> product.getId() == productId)
                .findFirst().orElse(null);

        Sale s = this.sales.stream()
                .filter(sale -> sale.getId() == saleId)
                .findFirst().orElse(null);
        if(s!=null){
            s.setCustomer(c);
            s.setProduct(p);
        }
    }

    @Override
    public List<Sale> getSales() {
        return this.sales;
    }
}
