package com.payment.services;

import java.util.List;

import com.payment.dtos.PaymentDTO;

public interface PaymentService {

	void createPayment(PaymentDTO paymentDTO);

	List<PaymentDTO> getAllData();

}
