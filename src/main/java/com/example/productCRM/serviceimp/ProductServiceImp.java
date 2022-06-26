package com.example.productCRM.serviceimp;

import com.example.productCRM.model.Product;
import com.example.productCRM.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    public static List<Product> productList = new ArrayList<>();
    @Override
    public void addProduct(Product product) {
        this.productList.add(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product p = this.productList.stream()
                .filter(product -> product.getId()==id)
                .findFirst().orElse(null);
        if(p!=null){
            productList.remove(p);
        }
    }

    @Override
    public void updateProduct(Product product) {
        Product p = this.productList.stream()
                .filter(pr -> pr.getId()==product.getId())
                .findFirst().orElse(null);
        if(p!=null){
            p.setName(product.getName());
            p.setPrice(product.getPrice());
        }
    }

    @Override
    public List<Product> getProductList() {
        return this.productList;
    }
}
