package com.rest.controllers;

import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.dto.CarDTO;
import com.rest.entities.Car;
import com.rest.repositories.CarRepository;
import com.rest.services.CarService;


/*
 @RequestBody
 @PathVariable
 @ResponseBody
 @RestController= @Controller + @ResponseBody(java object ==> json object)
 ResponseEntity==>manipulate response headers ==> Http status code
 
 1. Idempotent
 2. queries in properties file
 3. SSL/TLS certificate
 */

@RestController
public class CarController {

	//request-response
	//@RequestMapping
	//request :: get, post, delete, put, patch
	//response :: json
	
	//CRUD ==> 
	//insert ==> @PostMapping , ==>addCar(Car c1) ==>save()
	//update ==> @PutMapping, @PatchMapping, ==> save()
	//delete==> @DeleteMapping,  ==>deleteById()
	//select==> @GetMapping ==>findAll(), findById()
	
	
	@Autowired
	CarService service;	
	
	@GetMapping("/login")
	//@RequestMapping(value = "/login", method = RequestMethod.GET)
	String loginHandler() {		
		return "welcome to login page";
	}
	
	
	//select * from car==>repo.findAll()
	@GetMapping("/getCar")
	ResponseEntity<List<Car>> method2() {
		//Car c1 = new Car("TATA", "Nexon", 1200000);		
		List<Car> cars = service.getAllCars();		
		ResponseEntity<List<Car>> en = new ResponseEntity<List<Car>>(cars, HttpStatus.ACCEPTED);			
		return en;		
	}
	
	@PostMapping("/add")
	String addCar(@RequestBody CarDTO c1) {
		//service:: addCarData()
		service.addCarData(c1);
		return "Car data inserted";
	}


	//request parameter, path variable
	//delete?id=10
	//delete/10
	//delete from Car where carId = ?
	
}