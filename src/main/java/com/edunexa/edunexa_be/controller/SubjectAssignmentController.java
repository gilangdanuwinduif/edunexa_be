package com.edunexa.edunexa_be.controller;

import com.edunexa.edunexa_be.dto.SubjectAssignmentRequest;
import com.edunexa.edunexa_be.entity.*;
import com.edunexa.edunexa_be.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assignments")
@RequiredArgsConstructor
public class SubjectAssignmentController {

    private final SubjectAssignmentRepository assignmentRepository;
    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;
    private final ClassRepository classRepository;

    @PostMapping
    public ResponseEntity<?> assign(@RequestBody SubjectAssignmentRequest request) {
        Teacher teacher = teacherRepository.findById(request.getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        Subject subject = subjectRepository.findById(request.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        SchoolClass schoolClass = classRepository.findById(request.getClassId())
                .orElseThrow(() -> new RuntimeException("Class not found"));

        SubjectAssignment assignment = SubjectAssignment.builder()
                .teacher(teacher)
                .subject(subject)
                .schoolClass(schoolClass)
                .academicYear(request.getAcademicYear())
                .semester(request.getSemester())
                .build();

        return ResponseEntity.ok(assignmentRepository.save(assignment));
    }

    @GetMapping("/class/{classId}")
    public ResponseEntity<?> getByClass(@PathVariable String classId) {
        return ResponseEntity.ok(assignmentRepository.findBySchoolClassId(classId));
    }
}