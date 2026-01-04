package com.edunexa.edunexa_be.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String username;
    private String password;

}
