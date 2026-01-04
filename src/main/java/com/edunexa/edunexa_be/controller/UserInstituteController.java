package com.edunexa.edunexa_be.controller;

import com.edunexa.edunexa_be.dto.UserInstituteRequest;
import com.edunexa.edunexa_be.entity.Institute;
import com.edunexa.edunexa_be.entity.User;
import com.edunexa.edunexa_be.entity.UserInstitute;
import com.edunexa.edunexa_be.repository.InstituteRepository;
import com.edunexa.edunexa_be.repository.UserInstituteRepository;
import com.edunexa.edunexa_be.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-institutes")
@RequiredArgsConstructor
public class UserInstituteController {

    private final UserInstituteRepository userInstituteRepository;
    private final UserRepository userRepository;
    private final InstituteRepository institueRepository;

    @PostMapping("/assign")
    public ResponseEntity<?> assignUserToInstitute(@RequestBody UserInstituteRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Institute institute = institueRepository.findById(request.getInstituteId())
                .orElseThrow(() -> new RuntimeException("Institute not found"));

        UserInstitute mapping = UserInstitute.builder()
                .user(user)
                .institute(institute)
                .position(request.getPosition())
                .build();

        return ResponseEntity.ok(userInstituteRepository.save(mapping));
    }
}