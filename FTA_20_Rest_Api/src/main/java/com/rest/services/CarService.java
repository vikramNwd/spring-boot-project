package com.rest.services;

import java.util.List;

import com.rest.dto.CarDTO;
import com.rest.entities.Car;

public interface CarService {

	//crud operation
	void addCarData(CarDTO c1);
	List<Car> getAllCars();
	
}