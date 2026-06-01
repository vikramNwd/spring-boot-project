package com.cart.dtos;

import java.time.LocalDate;


public class CartProductsDto {

	int cartProductId;
		
	CartDto cart;
	
	int productId;
	
	String productname;
	
	double productPrice;
	
	LocalDate expectedDeliveryDate;
	 
	int quantity;
	
	LocalDate addedAt;

	public int getCartProductId() {
		return cartProductId;
	}

	public void setCartProductId(int cartProductId) {
		this.cartProductId = cartProductId;
	}

	public CartDto getCart() {
		return cart;
	}

	public void setCart(CartDto cart) {
		this.cart = cart;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public LocalDate getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(LocalDate expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDate getAddedAt() {
		return addedAt;
	}

	public void setAddedAt(LocalDate addedAt) {
		this.addedAt = addedAt;
	}
	
	

}