package com.recruiter.jobs_service.feign;

import com.recruiter.jobs_service.model.NotificationMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "CHATNOTIFICATION-SERVICE")
public interface NotificationClient {

    @PostMapping("/api/v1/jsonMessage")
    ResponseEntity<String> sendJsonMessage(@RequestBody NotificationMessage seeker);
}
