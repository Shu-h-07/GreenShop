package org.example.greenshop.repository;

import org.example.greenshop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category , Integer> {

    Optional<Category> existsById(Category categoryId);
}
