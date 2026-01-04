package com.edunexa.edunexa_be.dto;

import lombok.Data;

@Data
public class StudentRequest {
    private String userId;
    private String classId;
    private String nis;
    private String nisn;
}