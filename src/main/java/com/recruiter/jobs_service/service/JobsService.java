package com.recruiter.jobs_service.service;

import com.recruiter.jobs_service.model.CreateJobRequest;
import com.recruiter.jobs_service.model.Jobs;
import com.recruiter.jobs_service.repository.JobsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JobsService {
    private final JobsRepository jobsRepository;

    public JobsService(JobsRepository jobsRepository) {
        this.jobsRepository = jobsRepository;
    }

    public String create(CreateJobRequest request) {
        Jobs jobs = new Jobs();
        try {
            jobs.setJobTitle(request.getJobTitle());
            jobs.setJobCategory(request.getJobCategory());
            jobs.setJobType(request.getJobType());
            jobs.setJobLevel(request.getJobLevel());
            jobs.setExperience(request.getExperience());
            jobs.setQualification(request.getQualification());
            jobs.setSalary(request.getSalary());
            jobs.setSkills(request.getSkills());
            jobs.setCountry(request.getCountry());
            jobs.setState(request.getState());
            jobs.setCity(request.getCity());
            jobs.setPincode(request.getPincode());
            jobs.setCompany(request.getCompany());
            jobs.setPostedTime(LocalDateTime.now());
            jobs.setUser(request.getUserId());
            jobs.setDescription(request.getDescription());
            jobs.setRequirements(request.getRequirements());
            jobs.setResponsibilities(request.getResponsibilities());
            jobsRepository.save(jobs);
            // Persist or process the 'jobs' entity further (e.g., save to database)

            return "Job created successfully!";
        } catch (Exception e) {
            // Handle any specific exceptions or log the error
            e.printStackTrace();
            return "Failed to create job: " + e.getMessage();
        }
    }


    public List<Jobs> findJobsByUserId(Integer user) {
        try {
            List<Jobs> jobs = jobsRepository.findByUser(user);
            return jobs;
        } catch (Exception e) {
            // Handle any specific exceptions or log the error
            e.printStackTrace();
            throw new RuntimeException("Failed to find jobs by user id: " + user);
        }
    }

    public List<Jobs> findAllJobs() {
        try {
            List<Jobs> jobs = jobsRepository.findAll();
            return jobs;
        } catch (Exception e) {
            // Handle any specific exceptions or log the error
            e.printStackTrace();
            throw new RuntimeException("Failed to find jobs");
        }
    }
}
