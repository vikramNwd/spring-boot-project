package com.cart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.dtos.CartProductsDto;
import com.cart.services.CartService;

//			(DTO)		(entity)
//controller ==> service ==> repository

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartService cartService;
	
	@PostMapping("/add-to-cart")
	void addTocart(@RequestBody CartProductsDto cartProductsDto) {
		//extract loggedInUserId from request header
		int userId = 11;
		cartService.addCartData(cartProductsDto, userId);
	}
	
}