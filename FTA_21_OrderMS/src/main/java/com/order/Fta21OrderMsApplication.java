package com.order;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class Fta21OrderMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Fta21OrderMsApplication.class, args);
	}
	
	/*Bean creation method under @Configuration annotation, but no need to write @Configuration bcoz it is already
	comes under @SpringBootApplication annotation*/
	
	@Bean
	ModelMapper getModelMapper() {
		return new  ModelMapper();
	}
	
	@Bean 	
	@LoadBalanced
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
