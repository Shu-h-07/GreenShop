package org.example.greenshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private String firstName;
    private String lastName;
    private String country;
    private String city;
    private String street;
    private String state;
    private String zip;
    private String email;
    private String phoneNumber;
    private String order_notes;
}
