package com.edunexa.edunexa_be.controller;

import com.edunexa.edunexa_be.dto.ClassRequest;
import com.edunexa.edunexa_be.entity.Institute;
import com.edunexa.edunexa_be.entity.SchoolClass;
import com.edunexa.edunexa_be.repository.ClassRepository;
import com.edunexa.edunexa_be.repository.InstituteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// import java.util.List;

@RestController
@RequestMapping("/api/classes")
@RequiredArgsConstructor
public class ClassController {
    private final ClassRepository classRepository;
    private final InstituteRepository instituteRepository;

    @PostMapping
    public ResponseEntity<?> CreateClass(@RequestBody ClassRequest request) {
        Institute institute = instituteRepository.findById(request.getInstituteId())
                .orElseThrow(() -> new RuntimeException("Institute not found"));

        SchoolClass schoolClass = SchoolClass.builder()
                .name(request.getName())
                .level(request.getLevel())
                .academicYear(request.getAcademicYear())
                .institute(institute)
                .build();

        return ResponseEntity.ok(classRepository.save(schoolClass));
    }

    @GetMapping("/institute/{instituteId}")
    public ResponseEntity<?> getClassesByInstitute(@PathVariable String instituteId) {
        return ResponseEntity.ok(classRepository.findByInstituteId(instituteId));
    }
}