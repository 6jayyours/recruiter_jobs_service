package com.recruiter.jobs_service.controller;

import com.recruiter.jobs_service.model.Applications;
import com.recruiter.jobs_service.model.CreateJobRequest;
import com.recruiter.jobs_service.model.Jobs;
import com.recruiter.jobs_service.model.UpdateStatusRequest;
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

    @GetMapping("/getAllJobsAdmin")
    public ResponseEntity<List<Jobs>> getAllJobsAdmin() {
        return ResponseEntity.ok(jobsService.findAllJobsAdmin());
    }

    @GetMapping("/getJob")
    public ResponseEntity<Jobs> getJob(@RequestParam Integer id) {
        return ResponseEntity.ok(jobsService.findJobById(id));
    }


    @PostMapping("/apply")
    public ResponseEntity<String> applyForJob(@RequestParam("resume") MultipartFile resumeFile,
                                              @RequestParam("userId") Integer userId,
                                              @RequestParam("jobId") Integer jobId) {

        return ResponseEntity.ok(applicationsService.applyJob(resumeFile, userId, jobId));
    }



    @GetMapping("/getAllApps")
    public ResponseEntity<List<Applications>> getAllApps() {
        return ResponseEntity.ok(applicationsService.findAllApps());
    }

    @GetMapping("/getMyApps")
    public ResponseEntity<List<Applications>> getMyApps(Integer id) {
        return ResponseEntity.ok(applicationsService.findApplicationsByAppliedBy(id));
    }

    @GetMapping("/getMyJobApps")
    public ResponseEntity<List<Applications>> getMyJobApps(Integer id) {
        return ResponseEntity.ok(applicationsService.findByPostedId(id));
    }

    @GetMapping("/getSingleJobApps")
    public ResponseEntity<List<Applications>> getSingleJobApps(Integer id) {
        return ResponseEntity.ok(applicationsService.findByJob(id));
    }

    @PostMapping("/updateStatus")
    public ResponseEntity<String> updateApplicationStatus(@RequestBody UpdateStatusRequest request) {

        Integer applicationId = request.getApplicationId();
        String status = request.getStatus();
        System.out.println(applicationId+status);
        String updatedStatus = applicationsService.updateStatus(applicationId, status);

        return ResponseEntity.ok(updatedStatus);
    }

    @PostMapping("/blockJob")
    public ResponseEntity<String> blockJob(@RequestParam Integer id) {
        return ResponseEntity.ok(jobsService.blockJob(id));
    }


}
