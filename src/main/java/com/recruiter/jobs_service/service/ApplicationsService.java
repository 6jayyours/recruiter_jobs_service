package com.recruiter.jobs_service.service;

import com.recruiter.jobs_service.feign.AuthClient;
import com.recruiter.jobs_service.model.Applications;
import com.recruiter.jobs_service.model.Jobs;
import com.recruiter.jobs_service.model.UserDTO;
import com.recruiter.jobs_service.repository.ApplicationsRepository;
import com.recruiter.jobs_service.repository.JobsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ApplicationsService {
    private final AuthClient authClient;

    private final StorageService storageService;

    private final ApplicationsRepository applicationsRepository;

    private final JobsRepository jobsRepository;

    public ApplicationsService(AuthClient authClient, StorageService storageService, ApplicationsRepository applicationsRepository, JobsRepository jobsRepository) {
        this.authClient = authClient;
        this.storageService = storageService;
        this.applicationsRepository = applicationsRepository;
        this.jobsRepository = jobsRepository;


    }


    public String applyJob(MultipartFile resumeFile, Integer userId, int jobId) {
        try {
            String url = storageService.uploadVerificationDoc(resumeFile);
            UserDTO applicant = authClient.getUserById(userId).getBody();
            Jobs jobs = jobsRepository.findById(jobId).orElseThrow();
            Integer id = jobs.getUser();
            UserDTO recruiter = authClient.getUserById(id).getBody();
            Applications application = new Applications();
            application.setJobId(jobId);
            application.setApplicant(applicant.getFirstName()+" "+applicant.getLastName());
            application.setAppliedTime(LocalDateTime.now());
            application.setJobTitle(jobs.getJobTitle());
            application.setPostedBy(recruiter.getFirstName()+" "+recruiter.getLastName());
            application.setDownloadUrl(url);
            application.setPostedId(recruiter.getId());
            application.setStatus("open");
            applicationsRepository.save(application);
            return "Application submitted successfully.";
        }catch (Exception e) {
            return "Failed to apply for job: " + e.getMessage();
        }
    }


    public List<Applications> findByPostedId(Integer postedId) {
        List<Applications> applications = applicationsRepository.findByPostedId(postedId);
        return applications;
    }

    public List<Applications> findAllApps() {
        try {
            List<Applications> apps = applicationsRepository.findAll();
            return apps;
        }catch (Exception e) {
            // Handle any specific exceptions or log the error
            e.printStackTrace();
            throw new RuntimeException("Failed to find Applications");
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
