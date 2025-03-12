package org.example.greenshop.repository;

import org.example.greenshop.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepo extends JpaRepository<Shop , Integer> {

}
