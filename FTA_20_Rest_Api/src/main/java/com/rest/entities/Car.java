package com.rest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;




@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int carId;
	
	String company;
	
	String model;
	
	double price;
		

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	
	public Car() {
		super();
	}

	public Car(String company, String model, double price) {
		super();
		this.company = company;
		this.model = model;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", company=" + company + ", model=" + model + ", price=" + price + "]";
	}
	
	
	
	
}