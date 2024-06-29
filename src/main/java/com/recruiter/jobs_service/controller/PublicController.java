package com.recruiter.jobs_service.controller;

import com.recruiter.jobs_service.model.Jobs;
import com.recruiter.jobs_service.service.JobsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/publicJobs")
public class PublicController {

    private final JobsService jobsService;

    public PublicController(JobsService jobsService) {
        this.jobsService = jobsService;
    }

    @GetMapping("/getAllJobs")
    public ResponseEntity<List<Jobs>> getAllJobs() {
        return ResponseEntity.ok(jobsService.findAllJobs());
    }
}
