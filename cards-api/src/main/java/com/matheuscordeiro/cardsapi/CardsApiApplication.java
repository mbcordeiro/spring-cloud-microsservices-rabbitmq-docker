package com.matheuscordeiro.cardsapi;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableRabbit
public class CardsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApiApplication.class, args);
	}

}
