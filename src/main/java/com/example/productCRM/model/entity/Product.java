package com.example.productCRM.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="product")
public class Product extends BaseEntity{

    @Column(name="name")
    private String name;
    @Column(name="price")
    private Double price;

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
