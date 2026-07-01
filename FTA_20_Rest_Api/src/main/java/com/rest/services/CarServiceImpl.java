package com.rest.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rest.controllers.CarController;
import com.rest.dto.CarDTO;
import com.rest.entities.Car;
import com.rest.repositories.CarRepository;

@Service
public class CarServiceImpl implements CarService {

	// 1.DTO <==> entity
	// 2. call repo methods

	@Autowired
	CarRepository repo;

	@Override
	public void addCarData(CarDTO c1) {
		// call repo method :: save()
		// carDto ==> Car entity
		Car cx = new Car(c1.getCompany(), c1.getModel(), c1.getPrice());
		repo.save(cx);
	}

	@Override
	public List<Car> getAllCars() {
		return repo.findAll();
		
	}

	
}