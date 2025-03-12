package org.example.greenshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshop.model.Address;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phone_Number;
    private Address address;
    private String order_nodes;
    private LocalDateTime created_date = LocalDateTime.now();}
