package org.example.greenshop.repository;

import org.example.greenshop.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment , Integer> {
}
