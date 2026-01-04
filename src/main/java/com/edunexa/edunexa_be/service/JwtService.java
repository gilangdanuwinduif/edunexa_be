package com.edunexa.edunexa_be.service;

import io.jsonwebtoken.Jwts;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.interfaces.RSAPrivateKey;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class JwtService {

    private final RSAPrivateKey privateKey;

    public JwtService(RSAPrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .claim("roles", userDetails.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 12000 * 60 * 60)) // 12 Jam
                .signWith(privateKey, Jwts.SIG.RS256)
                .compact();
    }
}