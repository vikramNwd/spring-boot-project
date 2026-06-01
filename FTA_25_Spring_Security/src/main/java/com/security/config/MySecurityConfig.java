package com.security.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.boot.security.autoconfigure.web.servlet.SecurityFilterProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/*
 	Java ==> to create object ==> design patterns ==> Builder
 	Student s = new Student(10,"ram","sb");
 	builder.rollno(10).sname("ram").course("springboot").build();
 	
 	class Student{
 		int rollno;
 		String sname;
 		String course;
 	}
 	
 	class StudentBuilder{
 		Student build(){
 			Student s = new Student();
 			s.setRollno(rollno);
 			return s;
 		}
 	}
 */

@Configuration
@EnableWebSecurity
public class MySecurityConfig {

	/*
	 1. Open "/home" endpoint for all
	 2. Open "FormLogin" for all
	 3. Except for "/home" and FormLogin, all the other requests should be authenticated(validates user)
	 */
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) {
		return http.authorizeHttpRequests(r -> r.requestMatchers("/home").permitAll().anyRequest().authenticated())
				.formLogin(page -> page.permitAll())
				.build();
	}
}