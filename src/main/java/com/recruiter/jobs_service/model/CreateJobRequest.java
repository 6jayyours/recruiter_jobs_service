package com.recruiter.jobs_service.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateJobRequest {
    private String jobTitle;

    private String jobCategory;

    private String jobType;

    private String jobLevel;

    private String experience;

    private String qualification;

    private String salary;

    private String skills;

    private String country;

    private String state;

    private String city;

    private String pincode;

    private String company;

    private LocalDateTime postedTime;

    private Integer userId;

    private String description;

    private String requirements;

    private String responsibilities;
}
