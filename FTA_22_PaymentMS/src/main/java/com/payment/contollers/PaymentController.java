package com.payment.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.dtos.PaymentDTO;
import com.payment.services.PaymentService;

@RestController
@RequestMapping("/payments")

public class PaymentController {
	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/create")
	void createPayment(@RequestBody PaymentDTO paymentDTO) {
		paymentService.createPayment(paymentDTO);
	}
	
	@GetMapping("/all")
	List<PaymentDTO> getAllData() throws Exception{
//		return paymentService.getAllData();		
		System.out.println("============payment method called=========");
		throw new Exception("============Exception in Payment MS===========");
	}
	

}
