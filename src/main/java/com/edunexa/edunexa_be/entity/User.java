package com.edunexa.edunexa_be.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id; //

    @Column(nullable = false)
    private String firstName; // [cite: 26]

    @Column(nullable = false)
    private String lastName; // [cite: 27]

    @Column(unique = true, nullable = false)
    private String username; // [cite: 28]

    @Column(nullable = false)
    private String password; // [cite: 32]

    @Column(unique = true)
    private String email; // [cite: 30]

    private String phoneNumber; // [cite: 31]

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role; //

    private String address; //
    private LocalDate birthdate; // [cite: 34]
    private String city; // [cite: 35]
    private String district; // [cite: 36]
    private String subDistrict; // [cite: 37]
    private String postalCode; // [cite: 38]
    private String gender; // [cite: 39]
    private String imagePath; // [cite: 41]
    private String status; // [cite: 42]

    @Column(updatable = false)
    private LocalDateTime createdAt; //
    private LocalDateTime updatedAt; //

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return "ACTIVE".equalsIgnoreCase(status);
    }

}
