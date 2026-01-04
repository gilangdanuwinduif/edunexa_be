package com.edunexa.edunexa_be.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // untuk menghubungkan dengan entitas User

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private SchoolClass schoolClass; // untuk menghubungkan dengan entitas SchoolClass

    @Column(unique = true)
    private String nis; // Nomor Induk Siswa (NIS)
    private String nisn; // Nomor Induk Siswa Nasional (NISN)

}
