package com.edunexa.edunexa_be.repository;

import com.edunexa.edunexa_be.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, String> {
    List<Subject> findByInstituteId(String instituteId);
}
