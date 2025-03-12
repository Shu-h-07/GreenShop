package org.example.greenshop.repository;

import org.example.greenshop.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users , Integer> {
    boolean existsByEmail(String email);
}
