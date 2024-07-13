package com.recruiter.jobs_service.repository;

import com.recruiter.jobs_service.model.Applications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationsRepository extends JpaRepository<Applications, Integer> {
    List<Applications> findByPostedId(Integer postedId);

    List<Applications> findByAppliedBy(Integer appliedBy);

    List<Applications> findByJobId(Integer id);

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN TRUE ELSE FALSE END FROM Applications a WHERE a.jobId = :jobId AND a.appliedBy = :appliedBy")
    boolean findApplicationByJobIdAndAppliedBy(@Param("jobId") Integer jobId, @Param("appliedBy") Integer appliedBy);
}
