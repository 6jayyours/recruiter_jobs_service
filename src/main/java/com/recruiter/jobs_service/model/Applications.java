package com.recruiter.jobs_service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "applications")
public class Applications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer applicationId;
    private Integer jobId;
    private LocalDateTime appliedTime;
    private String status;
    private String postedBy;
    private String applicant;
    private String jobTitle;
    private String resumeFileName;
    private String downloadUrl;
}
