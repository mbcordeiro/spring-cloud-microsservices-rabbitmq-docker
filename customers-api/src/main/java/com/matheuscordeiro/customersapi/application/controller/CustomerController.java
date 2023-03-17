package com.matheuscordeiro.customersapi.application.controller;

import com.matheuscordeiro.customersapi.application.presentation.CustomerRequest;
import com.matheuscordeiro.customersapi.application.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public String getStatus() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody CustomerRequest customerRequest) {
        final var customer = customerRequest.toCustomer();
        customerService.save(customer);
        final var uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .query("document={document}")
                .buildAndExpand(customer.getDocument())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(params = "document")
    public ResponseEntity<?> getByDocument(@RequestParam("document") String document) {
        final var customer = customerService.findByDocument(document);
        if (customer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }
}