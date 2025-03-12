package org.example.greenshop.repository;

import org.example.greenshop.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagsRepo extends JpaRepository<Tags , Integer> {
}
