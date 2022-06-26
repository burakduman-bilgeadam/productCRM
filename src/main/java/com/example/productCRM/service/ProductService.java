package com.example.productCRM.service;

import com.example.productCRM.model.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);
    void deleteProduct(Long id);
    void updateProduct(Product product);
    List<Product> getProductList();
}
