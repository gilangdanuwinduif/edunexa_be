package com.edunexa.edunexa_be.dto;

import lombok.Data;

@Data
public class InstitueRequest {
    private String name;
    private String phone;
    private String email;
    private String address;
    private String website;
    private String accreditation;
    private String description;
}