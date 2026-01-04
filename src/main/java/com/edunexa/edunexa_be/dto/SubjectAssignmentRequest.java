package com.edunexa.edunexa_be.dto;

import lombok.Data;

@Data
public class SubjectAssignmentRequest {
    private String teacherId;
    private String subjectId;
    private String classId;
    private String academicYear;
    private String semester;
}