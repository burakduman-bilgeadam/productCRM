package com.example.productCRM.service;

import com.example.productCRM.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    void addProduct(ProductDTO productDTO);
    void deleteProduct(Long id);
    void updateProduct(ProductDTO productDTO);
    List<ProductDTO> getProductList();
}
