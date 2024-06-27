package com.recruiter.jobs_service.feign;

import com.recruiter.jobs_service.model.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "AUTH-SERVICE")
public interface AuthClient {

    @GetMapping("/api/v1/user/candidate")
    ResponseEntity<UserDTO> getUserById(@RequestParam Integer id);

}
