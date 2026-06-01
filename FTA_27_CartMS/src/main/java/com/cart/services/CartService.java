package com.cart.services;

import com.cart.dtos.CartProductsDto;

public interface CartService {

	void addCartData(CartProductsDto cartProductsDto, int userId);
	double calculateCartAmount(int cartId);
}