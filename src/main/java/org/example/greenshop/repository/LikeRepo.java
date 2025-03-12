package org.example.greenshop.repository;

import org.example.greenshop.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepo extends JpaRepository<Like , Integer> {
}
