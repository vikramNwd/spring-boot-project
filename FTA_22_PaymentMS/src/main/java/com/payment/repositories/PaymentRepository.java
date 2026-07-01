package com.payment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.entities.Payments;

public interface PaymentRepository extends JpaRepository<Payments, Integer> {

}
