package com.recruiter.jobs_service.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private boolean status;
    private boolean subscription;
    private String idImageUrl;
    private LocalDateTime registrationDate;
}
