package com.recruiter.jobs_service.repository;

import com.recruiter.jobs_service.model.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, Integer> {

    List<Jobs> findByUser(Integer user);

    List<Jobs> findByStatus(String open);
}
