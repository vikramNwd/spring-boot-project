package com.fta;

import java.util.List;
import java.util.Optional;

import org.hibernate.boot.model.source.spi.Sortable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.fta.entities.Laptop;
import com.fta.repositories.LaptopRepository;

/*
 1. PagingAndSortingRepository, JpaRepository
 2. query methods
 3. @Query annotation
 4. proxy classes at runtime ::SimpleJpaRepository(for basic crud methods), PartTreeJpaQuery(Query Methods), @Query executes directly
 5. second level cache(stores result as Id=>object, does not store query unless specified explicitly) 
 */

@SpringBootApplication
public class Fta19SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(Fta19SpringDataJpaApplication.class, args);						
		LaptopRepository repo = context.getBean(LaptopRepository.class);
		
		System.out.println("hi from springboot");		
	
		Laptop l1 = new Laptop();
		l1.setModel("acerThree");
		l1.setCompany("acer");
		l1.setPrice(60000);
		
		//insert
		//repo.save(l1);
		
		//findAll ==> select * from Laptop
		//List<Laptop> list1= (List)repo.findAll();
		//System.out.println(list1);
		
		
		//findById ==> select * from Laptop where laptopId = 102
		//get==> select * from Laptop where laptopId = ?
//		Optional<Laptop> op= repo.findById(102);
//		Laptop l2 = op.orElse(new Laptop());
//		l2.getPrice();
//		System.out.println(l2);
		
		
		//deleteById ==> delete from Laptop where laptopid = 52
		//repo.deleteById(52);
		
		//delete * from laptop
		//repo.deleteAll();
		
		//repo.deleteAllById(List.of(2,102));//2 query
		
		//repo.findAllById(List.of(1,2));
		
		//insert & update
		//merge ==> insert/update
		//
		
		//ID ==> primary key = none
		Laptop l3 = new Laptop();
		l3.setModel("dellThree");
		l3.setCompany("dell");
		l3.setPrice(120000);		
		//repo.save(l3);

		//update
		//ID==>primary key ==> 152
		//Laptop l4 = repo.findById(152).get();
		//l4.setModel("acerTwo");
		//repo.save(l4);
		
		//ID==>primary key ==> 155
		Laptop l5 = new Laptop();
		//l5.setLaptopId(202);
		l5.setModel("dellFour");
		l5.setCompany("dell");
		l5.setPrice(850000);
		//repo.save(l5);

		//Paging and sorting
		//2 record page ==> 3 page	
		Page<Laptop> p1= repo.findAll(PageRequest.of(3, 2));	
		System.out.println(p1.toList());
	
		List<Laptop> list3= repo.findAll(Sort.by("company").and(Sort.by("price")));
		list3.forEach(s -> System.out.println(s));

		//query methods such as findByCompany(), findByPriceLessThan(), findByPriceBetween(), findByModelStartingWith(), findByCompanyOrderByPriceDesc()
		
		List<Laptop> list4= repo.findByCompany("acer");
		
		//select * from Laptop where model = "acerTwo"
		List<Laptop> list5= repo.findByPrice(90000.0);
		
		List<Laptop> list6= repo.findByCompanyAndModel("acer", "acerThree");
		
		List<Laptop> list7 =repo.findByPriceLessThan(100000);
		
		List<Laptop> list8 = repo.findByCompanyLike("%el%");
		
		List<Laptop> list9= repo.findByCompanyOrderByPrice("dell");
		
		List<Laptop> list10= repo.findByCompany("dell", Sort.by("price"));
		
		
		List<String> list11= repo.getData(90000);
		
		list11.forEach(s -> System.out.println(s));
		
		
		
	}

	
	
}