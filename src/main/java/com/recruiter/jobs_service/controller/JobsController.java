package com.recruiter.jobs_service.controller;

import com.recruiter.jobs_service.model.CreateJobRequest;
import com.recruiter.jobs_service.model.Jobs;
import com.recruiter.jobs_service.service.JobsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobsController {

    private final JobsService jobsService;

    public JobsController(JobsService jobsService) {
        this.jobsService = jobsService;
    }

    @PostMapping("/postjob")
    public ResponseEntity<String> createJob(@RequestBody CreateJobRequest request) {
        return ResponseEntity.ok(jobsService.create(request));
    }

    @GetMapping("/getMyJobs")
    public ResponseEntity<List<Jobs>> getMyJobs(@RequestParam Integer user) {
        return ResponseEntity.ok(jobsService.findJobsByUserId(user));
    }


}
