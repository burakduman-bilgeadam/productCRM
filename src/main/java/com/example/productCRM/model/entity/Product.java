package com.example.productCRM.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedNativeQuery(name="Product.filterPrice"
, query ="select p from Product p where p.price>:price")
@NamedQuery(name="Product.averageProduct",
        query = "select avg(p.price) from Product p")
@Table(name="product")
public class Product extends BaseEntity{

    @Column(name="name")
    private String name;
    @Column(name="price")
    private Double price;

    @ManyToOne
    @JoinColumn(name="sale_id")
    private Sale sale;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
