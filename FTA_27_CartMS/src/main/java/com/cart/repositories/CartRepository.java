package com.cart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cart.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	//select * from Cart where userId = ?
	Cart findByUserId(int uid);
}