package com.order.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.order.dtos.PaymentDTO;

@FeignClient(name = "FTA-22-PaymentMS", path = "/payments")
public interface PaymentClient {
	@GetMapping("/all")
	List<PaymentDTO> getAllPayment();
	
	@PostMapping("/create")
	void savePaymentDetails();

}
