package com.order.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.order.dtos.OrdersDTO;
import com.order.dtos.PaymentDTO;


public interface OrderService {

	void addOrder(OrdersDTO ordersDTO);
	OrdersDTO getOrderById(int orderId);
	List<OrdersDTO> getAllOrders();
	List<PaymentDTO> getAllPaymentData();
}
