	package com.order.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.order.dtos.OrdersDTO;
import com.order.dtos.PaymentDTO;
import com.order.feignClient.PaymentClient;
import com.order.services.OrderService;

// Controller==>ServiceImpl==>Service==>Repository==>Entity
@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	RestTemplate template;
	
	@Autowired
	PaymentClient paymentClient;
	
	/*
	 goal : insert json object(values) into Orders
	 1. get json object into DTO
	 2. send DTO to service(call service method)
	 3. convert DTO to entity
	 4. send entity to repository
	 */

	@PostMapping("/create")
	void addOrder(@RequestBody OrdersDTO ordersDTO) {
		orderService.addOrder(ordersDTO);
		
	}
	
	/*
	 goal : 
	 */
	
	@GetMapping("/get/{orderId}")
	OrdersDTO getOrderById(@PathVariable("orderId") int orderId) {
	OrdersDTO o2 = 	orderService.getOrderById(orderId);
	return o2;
	}
	@GetMapping("/all")
	List<OrdersDTO> getAllOrders() {
		List<OrdersDTO> ol = orderService.getAllOrders();
		return ol;
	}
	@PatchMapping("/update-status/{orderId}")
	void updateOrderStatus() {
		
	}
	
	@GetMapping("/get-all-payment")
	List<PaymentDTO> getAllPaymentData() {
	    RestTemplate template = new RestTemplate();
//		List<PaymentDTO> list= template.getForObject("http://localhost:8083/payments/all", List.class);
//		List<PaymentDTO> list= template.getForObject("http://FTA-22-PaymentMS/payments/all", List.class);
		
	     List<PaymentDTO> l1 = orderService.getAllPaymentData();
		return l1;	
	}


}
