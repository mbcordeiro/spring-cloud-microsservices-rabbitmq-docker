package com.matheuscordeiro.customersapi.infra.repository;

import com.matheuscordeiro.customersapi.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
