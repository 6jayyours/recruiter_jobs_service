package com.recruiter.jobs_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateStatusRequest {
    private Integer applicationId;
    private String status;
}
