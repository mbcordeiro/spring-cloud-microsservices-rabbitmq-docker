package com.matheuscordeiro.customersapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String document;
    private String name;
    private Integer age;

    public Customer(String document, String name, Integer age) {
        this.document = document;
        this.name = name;
        this.age = age;
    }
}