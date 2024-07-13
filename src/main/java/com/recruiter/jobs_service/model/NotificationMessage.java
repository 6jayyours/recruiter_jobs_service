package com.recruiter.jobs_service.model;

import lombok.Data;

@Data
public class NotificationMessage {
    private String email;
    private String subject;
    private String content;

}
