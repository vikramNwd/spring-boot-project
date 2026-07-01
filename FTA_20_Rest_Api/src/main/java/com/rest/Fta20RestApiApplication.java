package com.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(namedQueriesLocation = "classpath:jpa-named-queries.properties")

public class Fta20RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Fta20RestApiApplication.class, args);
	}

}
