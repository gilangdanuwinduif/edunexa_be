package com.edunexa.edunexa_be.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "subject_assignments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubjectAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private SchoolClass schoolClass;

    private String academicYear; // Contoh: "2025/2026"
    private String semester; // Contoh: "Ganjil" atau "Genap"
}