package com.edunexa.edunexa_be.dto;

import lombok.Data;

@Data
public class UserInstituteRequest {
    private String userId;
    private String instituteId;
    private String position;
}