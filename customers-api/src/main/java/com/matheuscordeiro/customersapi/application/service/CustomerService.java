package com.matheuscordeiro.customersapi.application.service;

import com.matheuscordeiro.customersapi.domain.Customer;

import java.util.Optional;

public interface CustomerService {
    Customer save(Customer customer);

    Optional<Customer> findByDocument(String document);
}