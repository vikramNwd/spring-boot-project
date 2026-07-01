package com.payment.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.dtos.PaymentDTO;
import com.payment.entities.Payments;
import com.payment.repositories.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	PaymentRepository repo;
	
	@Autowired
	ModelMapper mapper;


	@Override
	public void createPayment(PaymentDTO paymentDTO) {
		Payments p1 = new Payments();
		mapper.map(paymentDTO, p1);
		repo.save(p1);
	}


	@Override
	public List<PaymentDTO> getAllData() {

List<Payments> paymentList= repo.findAll();
		
		return paymentList.stream()
			.map(p1 -> mapper.map(p1, PaymentDTO.class))
			.toList();
	}

}
