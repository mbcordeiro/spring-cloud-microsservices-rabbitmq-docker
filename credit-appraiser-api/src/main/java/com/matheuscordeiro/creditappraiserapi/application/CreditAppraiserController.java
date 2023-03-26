package com.matheuscordeiro.creditappraiserapi.application;

import com.matheuscordeiro.creditappraiserapi.domain.CustomerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("credit-appraiser")
public class CreditAppraiserController {
    @GetMapping
    public String status() {
        return "ok";
    }

    @GetMapping(value = "customer-credit", params = "document")
    public ResponseEntity<CustomerClient> retrieveCustomerClient(@RequestParam("document") String document) {
        return null;
    }
}