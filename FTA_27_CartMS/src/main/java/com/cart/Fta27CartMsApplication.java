package com.cart;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Fta27CartMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Fta27CartMsApplication.class, args);
	}

	@Bean
	ModelMapper createModelMapper() {
		return new ModelMapper();
	}
}