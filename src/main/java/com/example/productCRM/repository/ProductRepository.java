package com.example.productCRM.repository;

import com.example.productCRM.model.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
//name e göre sorgu
    //name veya price a göre sorgu

}
