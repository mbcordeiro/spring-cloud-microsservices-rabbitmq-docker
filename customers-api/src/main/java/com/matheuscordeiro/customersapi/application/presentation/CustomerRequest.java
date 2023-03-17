package com.matheuscordeiro.customersapi.application.presentation;

import com.matheuscordeiro.customersapi.domain.Customer;
import lombok.Data;

@Data
public class CustomerRequest {
    private String document;
    private String name;
    private Integer age;

    public Customer toCustomer() {
        return new Customer(document, name, age);
    }
}