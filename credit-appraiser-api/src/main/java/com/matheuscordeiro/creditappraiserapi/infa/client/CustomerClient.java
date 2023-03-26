package com.matheuscordeiro.creditappraiserapi.infa.client;

import com.matheuscordeiro.creditappraiserapi.domain.CustomerData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "customer-api", path = "/customer")
public interface CustomerClient {
    @GetMapping(params = "document")
    CustomerData getByDocument(@RequestParam ("document") String document);
}