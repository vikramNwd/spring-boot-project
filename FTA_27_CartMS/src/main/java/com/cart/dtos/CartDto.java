package com.cart.dtos;

import java.time.LocalDate;
import java.util.List;


public class CartDto {

	int cartId;
	
	int userId;
	
	List<CartProductsDto> productList;
	
	double totalAmount;
	
	LocalDate lastUpdateDate;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDate getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(LocalDate lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public List<CartProductsDto> getProductList() {
		return productList;
	}

	public void setProductList(List<CartProductsDto> productList) {
		this.productList = productList;
	}
	
	
	

}