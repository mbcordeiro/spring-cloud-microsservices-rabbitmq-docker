package com.matheuscordeiro.customersapi.application.service.impl;

import com.matheuscordeiro.customersapi.application.service.CustomerService;
import com.matheuscordeiro.customersapi.domain.Customer;
import com.matheuscordeiro.customersapi.infra.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Transactional
    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findByDocument(String document) {
        return customerRepository.findByDocument(document);
    }
}