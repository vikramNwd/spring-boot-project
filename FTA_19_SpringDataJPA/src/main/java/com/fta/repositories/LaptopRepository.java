package com.fta.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fta.entities.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer>{
	/*
	 save()
	 delete()
	 deleteById()
	 findById() ==> select * from Laptop where laptopId = ?
	 findAll()
	 
	 select * from Laptop where company = "acer" ==> query method, jpql
	 select * from Laptop where model = ?
	 select * from Laptop where price =?
	 select * from Laptop where company = "acer" and model="acerThree"
	 select * from Laptop where price < 100000
	 select * from Laptop where price between 70000 and 100000
	 select * from Laptop where company like %el%
	 select * from Laptop where company = ? order by price ASC
	 */
	
	List<Laptop> findByCompany(String comp);
	List<Laptop> findByModel(String m1);
	List<Laptop> findByPrice(double pr);
	List<Laptop> findByCompanyAndModel(String comp, String m1);
	List<Laptop> findByPriceLessThan(double pr);
	List<Laptop> findByCompanyLike(String comp);
	List<Laptop> findByCompanyOrderByPrice(String comp);
	List<Laptop> findByCompany(String comp, Sort sort);
	
	//select model from laptop where price = 80000
	@Query("select l.model from Laptop l where l.price = ?1")
	@NativeQuery("select model from laptop where price = ?1")
	List<String> getData(double pr);
	
	
	
	
	
	@Query("SELECT l FROM Laptop l WHERE l.company = ?1 AND l.model = ?2")
	List<Laptop> findLaptop(String comp, String model);
}