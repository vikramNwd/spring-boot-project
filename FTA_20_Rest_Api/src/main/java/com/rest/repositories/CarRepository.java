package com.rest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{

	//save()
	//deleteById()
	//findById()
	//findAll()
	
@Query("select c from Car c where c.price = :p and company = :c")
List<Car> getCarData(@Param("p") int p, @Param("c") String company);
	
	
	
	
}