package com.edunexa.edunexa_be.repository;

import com.edunexa.edunexa_be.entity.Institute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituteRepository extends JpaRepository<Institute, String> {
}