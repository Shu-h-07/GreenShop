package org.example.greenshop.repository;

import org.example.greenshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product , Integer> {
    boolean existsByName(String name);
}
