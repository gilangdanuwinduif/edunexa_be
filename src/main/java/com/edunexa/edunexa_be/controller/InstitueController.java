package com.edunexa.edunexa_be.controller;

import com.edunexa.edunexa_be.dto.InstitueRequest;
import com.edunexa.edunexa_be.entity.Institute;
import com.edunexa.edunexa_be.repository.InstituteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institues")
@RequiredArgsConstructor
public class InstitueController {

    private final InstituteRepository instituteRepository;

    @GetMapping
    public ResponseEntity<List<Institute>> getAll() {
        return ResponseEntity.ok(instituteRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Institute> create(@RequestBody InstitueRequest request) {
        Institute institue = Institute.builder()
                .name(request.getName())
                .phone(request.getPhone())
                .email(request.getEmail())
                .address(request.getAddress())
                .website(request.getWebsite())
                .accreditation(request.getAccreditation())
                .description(request.getDescription())
                .build();

        return ResponseEntity.ok(instituteRepository.save(institue));
    }
}