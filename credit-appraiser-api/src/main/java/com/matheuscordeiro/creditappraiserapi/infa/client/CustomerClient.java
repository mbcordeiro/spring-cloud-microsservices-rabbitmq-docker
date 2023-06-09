package com.matheuscordeiro.creditappraiserapi.infa.client;

import com.matheuscordeiro.creditappraiserapi.domain.CustomerData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "customers-api", path = "/customers")
public interface CustomerClient {
    @GetMapping(params = "document")
    ResponseEntity<CustomerData> getByDocument(@RequestParam ("document") String document);
}