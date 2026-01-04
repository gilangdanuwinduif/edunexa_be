package com.edunexa.edunexa_be.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String role;
    private String gender;
    private String birthdate;
    private String city;
    private String district;
    private String subDistrict;
    private String postalCode;
    private String imagePath;
    private String status;
}
