package org.example.greenshop.repository;

import org.example.greenshop.model.PriceRange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRangeRepo extends JpaRepository<PriceRange, Integer> {
}
