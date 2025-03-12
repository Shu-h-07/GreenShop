package org.example.greenshop.repository;

import org.example.greenshop.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<Login, Integer> {

    boolean existsByEmail(String email);
}

