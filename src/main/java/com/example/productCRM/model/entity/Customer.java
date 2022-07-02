package com.example.productCRM.model.entity;

import com.fasterxml.jackson.databind.ser.Serializers;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="customer")
public class Customer extends BaseEntity {
    /*@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_generator")
    @SequenceGenerator(name="book_generator", sequenceName = "book_seq", allocationSize=50)
    */

    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="birth_date")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
