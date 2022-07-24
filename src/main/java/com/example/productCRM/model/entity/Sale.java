package com.example.productCRM.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "sale")
    private List<Product> product;
}
