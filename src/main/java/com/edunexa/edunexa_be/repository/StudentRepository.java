package com.edunexa.edunexa_be.repository;

import com.edunexa.edunexa_be.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findBySchoolClassId(String classId);
}
