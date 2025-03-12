package org.example.greenshop.repository;

import org.example.greenshop.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address , Integer > {
}
