package com.edunexa.edunexa_be.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class ProfileResponse {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phoneNumber;
    private String address;
    private String gender;
    private String birthdate;
    private String city;
    private String district;
    private String subDistrict;
    private String postalCode;
    private String imagePath;
    private String status;
    private String role;
    private List<UserInstituteDetail> institutes;
}