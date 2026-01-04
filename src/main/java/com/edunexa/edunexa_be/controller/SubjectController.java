package com.edunexa.edunexa_be.controller;

import com.edunexa.edunexa_be.dto.SubjectRequest;
import com.edunexa.edunexa_be.entity.Institute;
import com.edunexa.edunexa_be.entity.Subject;
import com.edunexa.edunexa_be.repository.InstituteRepository;
import com.edunexa.edunexa_be.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectRepository subjectRepository;
    private final InstituteRepository institueRepository;

    @PostMapping
    public ResponseEntity<?> createSubject(@RequestBody SubjectRequest request) {
        Institute institute = institueRepository.findById(request.getInstituteId())
                .orElseThrow(() -> new RuntimeException("Institute not found"));

        Subject subject = Subject.builder()
                .name(request.getName())
                .code(request.getCode())
                .institute(institute)
                .build();

        return ResponseEntity.ok(subjectRepository.save(subject));
    }

    @GetMapping("/institute/{instituteId}")
    public ResponseEntity<?> getSubjectsByInstitute(@PathVariable String instituteId) {
        return ResponseEntity.ok(subjectRepository.findByInstituteId(instituteId));
    }
}