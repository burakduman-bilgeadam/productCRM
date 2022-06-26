package com.example.productCRM.controller;

import com.example.productCRM.model.Product;
import com.example.productCRM.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody Product product){
        this.productService.addProduct(product);
        return new ResponseEntity
                ("Başarılı", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity updateProduct
            (@RequestBody Product product){
        this.productService.updateProduct(product);
        return new ResponseEntity("Başarılı Kayıt",
                HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteProduct(@RequestParam(name="id")
                                            Long id){
        this.productService.deleteProduct(id);
        return ResponseEntity.ok("Silindi");
    }

    @GetMapping("/list")
    public ResponseEntity<List<Product>> getListProduct(){
       return ResponseEntity.ok(
               this.productService.getProductList());
    }

}
