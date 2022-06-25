package com.example.productCRM.model;

public class Sale {
    private Long id;
    private Product product;
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Sale(Long id, Product product, Customer customer) {
        this.id = id;
        this.product = product;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", product=" + product +
                ", customer=" + customer +
                '}';
    }
}
