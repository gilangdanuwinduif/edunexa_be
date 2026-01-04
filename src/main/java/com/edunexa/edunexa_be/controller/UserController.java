package com.edunexa.edunexa_be.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edunexa.edunexa_be.dto.ProfileResponse;
import com.edunexa.edunexa_be.dto.UserInstituteDetail;
// import com.edunexa.edunexa_be.dto.UserInstituteDetail;
// import com.edunexa.edunexa_be.dto.UserInstituteRequest;
import com.edunexa.edunexa_be.entity.User;
import com.edunexa.edunexa_be.repository.UserInstituteRepository;
import com.edunexa.edunexa_be.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserInstituteRepository userInstituteRepository;

    @GetMapping("/me")
    public ResponseEntity<?> getMyProfile() {
        // 1. Ambil email/username dari token yang sedang aktif
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        String currentEmail = authentication.getName();

        // 2. Cari data user di database
        User user = userRepository.findByUsernameOrEmail(currentUsername, currentEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 3. Cari daftar institusi yang terhubung dengan user ini
        List<UserInstituteDetail> institutes = userInstituteRepository.findByUserId(user.getId())
                .stream()
                .map(mapping -> UserInstituteDetail.builder()
                        .instituteName(mapping.getInstitute().getName())
                        .position(mapping.getPosition())
                        .address(mapping.getInstitute().getAddress())
                        .build())
                .collect(Collectors.toList());

        // 4. Bungkus dalam ProfileResponse
        ProfileResponse profile = ProfileResponse.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole().name())
                .institutes(institutes)
                .build();

        return ResponseEntity.ok(profile);
    }
}