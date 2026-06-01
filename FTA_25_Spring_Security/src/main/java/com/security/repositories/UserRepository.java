package com.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.entities.MyUser;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Integer>{

	/*
	 findById()
	 deleteById()
	 findAll()
	 save()
	 deleteAll()
	 
	 select * from MyUser where uname = ?
	 */
	
	
	MyUser findByUname(String username);

}