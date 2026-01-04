package com.edunexa.edunexa_be.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInstituteDetail {
    private String instituteName;
    private String position;
    private String address;
}