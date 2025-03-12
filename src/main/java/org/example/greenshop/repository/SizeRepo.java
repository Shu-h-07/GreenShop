package org.example.greenshop.repository;

import org.example.greenshop.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepo extends JpaRepository<Size, Integer> {
    boolean existsByName(String name);
}
