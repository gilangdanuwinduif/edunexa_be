package com.edunexa.edunexa_be.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "classes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name; // Contoh: "10-IPA-1"

    private String level; // Contoh: "10", "11", atau "XII"

    private String academicYear; // Contoh: "2024/2025"

    @ManyToOne
    @JoinColumn(name = "institute_id", nullable = false)
    private Institute institute;
}