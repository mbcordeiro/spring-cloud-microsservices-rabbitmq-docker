package com.matheuscordeiro.creditappraiserapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CreditAppraiserApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditAppraiserApiApplication.class, args);
	}

}
