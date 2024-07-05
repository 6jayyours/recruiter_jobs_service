package com.recruiter.jobs_service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "jobs")
@Data
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Column(name = "job_category", nullable = false)
    private String jobCategory;

    @Column(name = "job_type")
    private String jobType;

    @Column(name = "job_level")
    private String jobLevel;

    @Column(name = "experience")
    private String experience;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "salary")
    private String salary;

    @Column(name = "skills")
    private String skills;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "pincode")
    private String pincode;

    @Column(name = "company")
    private String company;

    @Column(name = "posted_time", nullable = false)
    private LocalDateTime postedTime;

    @Column(name = "user")
    private Integer user;

    @Column(name = "posted")
    private String posted;

    @Column(name = "status")
    private String status;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "requirements", columnDefinition = "TEXT")
    private String requirements;

    @Column(name = "responsibilities", columnDefinition = "TEXT")
    private String responsibilities;

}
