package com.edunexa.edunexa_be.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "institues")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Institute {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String phone;
    private String email;
    private String address;
    private String website;
    private String accreditation;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String imagePath;
}