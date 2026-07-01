package com.payment;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Fta22PaymentMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Fta22PaymentMsApplication.class, args);
	}
	@Bean
	ModelMapper getModelMapper() {
		return new  ModelMapper();
	}

}
