package com.example.productCRM.serviceimp;

import com.example.productCRM.model.dto.ProductDTO;
import com.example.productCRM.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    public static List<ProductDTO> productDTOList = new ArrayList<>();
    @Override
    public void addProduct(ProductDTO productDTO) {
        this.productDTOList.add(productDTO);
    }

    @Override
    public void deleteProduct(Long id) {
        ProductDTO p = this.productDTOList.stream()
                .filter(product -> product.getId()==id)
                .findFirst().orElse(null);
        if(p!=null){
            productDTOList.remove(p);
        }
    }

    @Override
    public void updateProduct(ProductDTO productDTO) {
        ProductDTO p = this.productDTOList.stream()
                .filter(pr -> pr.getId()== productDTO.getId())
                .findFirst().orElse(null);
        if(p!=null){
            p.setName(productDTO.getName());
            p.setPrice(productDTO.getPrice());
        }
    }

    @Override
    public List<ProductDTO> getProductList() {
        return this.productDTOList;
    }
}
