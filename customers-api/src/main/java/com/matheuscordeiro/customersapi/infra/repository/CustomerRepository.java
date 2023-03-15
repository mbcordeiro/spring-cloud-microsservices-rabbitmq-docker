package com.matheuscordeiro.customersapi.infra.repository;

import com.matheuscordeiro.customersapi.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByDocument(String document);
}
