package com.edunexa.edunexa_be.controller;

import com.edunexa.edunexa_be.dto.StudentRequest;
import com.edunexa.edunexa_be.entity.SchoolClass;
import com.edunexa.edunexa_be.entity.Student;
import com.edunexa.edunexa_be.entity.User;
import com.edunexa.edunexa_be.repository.ClassRepository;
import com.edunexa.edunexa_be.repository.StudentRepository;
import com.edunexa.edunexa_be.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final ClassRepository classRepository;

    @PostMapping
    public ResponseEntity<?> registerStudent(@RequestBody StudentRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        SchoolClass schoolClass = classRepository.findById(request.getClassId())
                .orElseThrow(() -> new RuntimeException("Class not found"));

        Student student = Student.builder()
                .user(user)
                .schoolClass(schoolClass)
                .nisn(request.getNisn())
                .nis(request.getNis())
                .build();

        return ResponseEntity.ok(studentRepository.save(student));
    }

    @GetMapping("/class/{classId}")
    public ResponseEntity<?> getStudentsByClass(@PathVariable String classId) {
        return ResponseEntity.ok(studentRepository.findBySchoolClassId(classId));
    }
}