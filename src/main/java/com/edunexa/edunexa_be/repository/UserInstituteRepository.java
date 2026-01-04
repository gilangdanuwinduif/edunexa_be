package com.edunexa.edunexa_be.repository;

import com.edunexa.edunexa_be.entity.UserInstitute;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserInstituteRepository extends JpaRepository<UserInstitute, String> {
    List<UserInstitute> findByUserId(String userId);

    List<UserInstitute> findByInstituteId(String instituteId);
}