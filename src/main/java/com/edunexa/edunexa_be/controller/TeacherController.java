package com.edunexa.edunexa_be.controller;

import com.edunexa.edunexa_be.dto.TeacherRequest;
import com.edunexa.edunexa_be.entity.Teacher;
import com.edunexa.edunexa_be.entity.User;
import com.edunexa.edunexa_be.repository.TeacherRepository;
import com.edunexa.edunexa_be.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherRepository teacherRepository;
    private final UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<Teacher>> getAll() {
        return ResponseEntity.ok(teacherRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Teacher> create(@RequestBody TeacherRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Teacher teacher = Teacher.builder()
                .nuptk(request.getNuptk())
                .nip(request.getNip())
                .spezialization(request.getSpezialization())
                .user(user)
                .build();

        return ResponseEntity.ok(teacherRepository.save(teacher));
    }
}
