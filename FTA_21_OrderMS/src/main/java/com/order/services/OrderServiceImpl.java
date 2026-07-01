package com.order.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.dtos.OrdersDTO;
import com.order.dtos.PaymentDTO;
import com.order.entities.Orders;
import com.order.feignClient.PaymentClient;
import com.order.repositories.OrderRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderRepository orderRepo;

	@Autowired
	ModelMapper mapper;
	
	@Autowired
	PaymentClient paymentClient;

	@Override
	public void addOrder(OrdersDTO ordersDTO) {
         //convert karna h dto object to entity object		
		//convert OrdersDTO to Entity object
		Orders o1 = new Orders();
		mapper.map(ordersDTO, o1);
		orderRepo.save(o1);
	}

	@Override
	public OrdersDTO getOrderById(int orderId) {
		
		Orders o1 = orderRepo.findById(orderId).orElse(new Orders());
		//OrdersDTO orderDTO = new OrdersDTO();
		//mapper.map(o1, orderDTO);
		OrdersDTO orderDTO= mapper.map(o1, OrdersDTO.class);
		return orderDTO;
		
	}

	@Override
	public List<OrdersDTO> getAllOrders() {
		
		List<Orders> orderList = orderRepo.findAll();
		//conversion :: List<Order> ==> List<OrderDTO>
		
		// stream api ==> map() ==> manipulate data ==> data value/type ==> Employee obj ==> salary(Double obj)	
		
		List<OrdersDTO> list = orderList.stream()										
										.map(order1 -> mapper.map(order1, OrdersDTO.class))
										.toList();
		
		return list;
	}

	@Override
	@CircuitBreaker(name = "cb1", fallbackMethod = "m1")
//	@Retry(name = "rt1", fallbackMethod ="m1")
	public List<PaymentDTO> getAllPaymentData() {
		
	System.out.println("================OrderMS :: calling paymentMS/all endpoint=============");
	List<PaymentDTO> list = paymentClient.getAllPayment();
	return list;	
	}
	
	public List <PaymentDTO> m1(Exception e){
		System.out.println("=========OrderMS :: fallback response ::======="+e.getMessage());
		return null;
	}

}
