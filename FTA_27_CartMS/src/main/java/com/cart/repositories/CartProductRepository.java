package com.cart.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cart.entities.CartProducts;

@Repository
public interface CartProductRepository extends JpaRepository<CartProducts, Integer>{

	List<CartProducts> findByCartCartId(int cartId);

}