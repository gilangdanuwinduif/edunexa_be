package com.edunexa.edunexa_be.repository;

import com.edunexa.edunexa_be.entity.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClassRepository extends JpaRepository<SchoolClass, String> {
    List<SchoolClass> findByInstituteId(String instituteId);
}