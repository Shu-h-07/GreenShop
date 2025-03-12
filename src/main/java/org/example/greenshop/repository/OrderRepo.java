package org.example.greenshop.repository;

import org.example.greenshop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order , Integer> {
}
