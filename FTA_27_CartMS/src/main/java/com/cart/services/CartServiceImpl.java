package com.cart.services;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.dtos.CartProductsDto;
import com.cart.entities.Cart;
import com.cart.entities.CartProducts;
import com.cart.repositories.CartProductRepository;
import com.cart.repositories.CartRepository;


//			(DTO)		(entity)
//controller ==> service ==> repository
//cartProductsDto ==> cartProducts(entity)
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	ModelMapper mapper;
	
	@Autowired
	CartProductRepository cartproductsRepo;
	
	@Autowired
	CartRepository cartRepo;
	
	@Override
	public void addCartData(CartProductsDto cartProductsDto, int userId) {
		CartProducts cartproducts= mapper.map(cartProductsDto, CartProducts.class);
		cartproducts.setExpectedDeliveryDate(LocalDate.now().plusDays(5));
		cartproducts.setTotalPrice(cartProductsDto.getQuantity() * cartProductsDto.getProductPrice());
		
		//get cart if by userId
		Cart cart = cartRepo.findByUserId(userId);
		
		if(cart == null) {
			cart = new Cart();
			cart.setUserId(userId);
			Cart newcart = cartRepo.save(cart);
			cartproducts.setCart(newcart);			
		}
		else {
			cartproducts.setCart(cart);
		}
		
		cartproductsRepo.save(cartproducts);	
		double totalAmount= calculateCartAmount(cartproducts.getCart().getCartId());
		cart.setTotalAmount(totalAmount);
		cartRepo.save(cart);
	}

	@Override
	public double calculateCartAmount(int cartId) {
		//select * from CartProducts where cartId = ?
		List<CartProducts> cartProducts = cartproductsRepo.findByCartCartId(cartId);
		double totalAmount = 0;
		for(CartProducts product:cartProducts) {
			totalAmount = totalAmount + product.getTotalPrice();
		}
		return totalAmount;
	}
	
	

}