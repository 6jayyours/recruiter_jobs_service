package com.recruiter.jobs_service.repository;

import com.recruiter.jobs_service.model.Applications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationsRepository extends JpaRepository<Applications, Integer> {
}
