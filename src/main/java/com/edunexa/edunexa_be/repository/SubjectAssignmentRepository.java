package com.edunexa.edunexa_be.repository;

import com.edunexa.edunexa_be.entity.SubjectAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubjectAssignmentRepository extends JpaRepository<SubjectAssignment, String> {
    List<SubjectAssignment> findBySchoolClassId(String classId);

    List<SubjectAssignment> findByTeacherId(String teacherId);
}