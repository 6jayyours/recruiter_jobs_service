package com.recruiter.jobs_service.controller;

import com.recruiter.jobs_service.model.Applications;
import com.recruiter.jobs_service.model.CreateJobRequest;
import com.recruiter.jobs_service.model.Jobs;
import com.recruiter.jobs_service.service.ApplicationsService;
import com.recruiter.jobs_service.service.JobsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobsController {

    private final JobsService jobsService;
    private final ApplicationsService applicationsService;

    public JobsController(JobsService jobsService, ApplicationsService applicationsService) {
        this.jobsService = jobsService;
        this.applicationsService = applicationsService;
    }

    @PostMapping("/postjob")
    public ResponseEntity<String> createJob(@RequestBody CreateJobRequest request) {
        return ResponseEntity.ok(jobsService.create(request));
    }

    @GetMapping("/getMyJobs")
    public ResponseEntity<List<Jobs>> getMyJobs(@RequestParam Integer user) {
        return ResponseEntity.ok(jobsService.findJobsByUserId(user));
    }

    @GetMapping("/getAllJobs")
    public ResponseEntity<List<Jobs>> getAllJobs() {
        return ResponseEntity.ok(jobsService.findAllJobs());
    }

    @GetMapping("/getJob")
    public ResponseEntity<Jobs> getJob(@RequestParam Integer id) {
        return ResponseEntity.ok(jobsService.findJobById(id));
    }


    @PostMapping("/apply")
    public ResponseEntity<String> applyForJob(@RequestParam("resume") MultipartFile resumeFile,
                                              @RequestParam("userId") Integer userId,
                                              @RequestParam("jobId") Integer jobId) {
        System.out.println(userId);
        System.out.println(resumeFile);
        System.out.println(jobId);
        return ResponseEntity.ok(applicationsService.applyJob(resumeFile, userId, jobId));
    }

    @GetMapping("/getMyApps")
    public ResponseEntity<List<Applications>> getMyApps(@RequestParam Integer postedId) {
        return ResponseEntity.ok(applicationsService.findByPostedId(postedId));
    }

}
