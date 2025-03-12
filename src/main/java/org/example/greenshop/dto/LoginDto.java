package org.example.greenshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LoginDto {
    private String name;
    private String email;
    private String password;
    private LocalDateTime created_date;
    private String confirm_password;
}
