package org.example.greenshop.repository;

import org.example.greenshop.model.Shoppingcard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingcardRepo extends JpaRepository<Shoppingcard , Integer> {
    boolean existsByName(String name);
}
