package com.example.productCRM.serviceimp;

import com.example.productCRM.model.dto.ProductDTO;
import com.example.productCRM.model.entity.Product;
import com.example.productCRM.repository.ProductRepository;
import com.example.productCRM.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public void addProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setInsertDate(new Date());
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void updateProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setId(productDTO.getId());
        productRepository.save(product);
    }

    @Override
    public List<ProductDTO> getProductList() {
        List<ProductDTO>productDTOs = new ArrayList<>();
        Iterator<Product> productIterator =
                productRepository.findAll().iterator();
        while(productIterator.hasNext()){
            ProductDTO productDTO = new ProductDTO();
            Product product = productIterator.next();
            productDTO.setName(product.getName());
            productDTO.setPrice(product.getPrice());
            productDTOs.add(productDTO);
        }
        return productDTOs;
    }
}
