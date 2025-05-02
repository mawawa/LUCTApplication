package com.luct.LUCTApplication.repositories;

import com.luct.LUCTApplication.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
