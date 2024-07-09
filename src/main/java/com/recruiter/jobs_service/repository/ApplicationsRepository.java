package com.recruiter.jobs_service.repository;

import com.recruiter.jobs_service.model.Applications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationsRepository extends JpaRepository<Applications, Integer> {
    List<Applications> findByPostedId(Integer postedId);

    List<Applications> findByAppliedBy(Integer appliedBy);
}
