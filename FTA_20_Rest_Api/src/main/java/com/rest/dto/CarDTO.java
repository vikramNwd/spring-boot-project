package com.rest.dto;

public class CarDTO {
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

	@Override
	public String toString() {
		return "CarDTO [carId=" + carId + ", company=" + company + ", model=" + model + ", price=" + price + "]";
	}
	
	
	
}