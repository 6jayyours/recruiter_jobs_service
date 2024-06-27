package com.recruiter.jobs_service.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.recruiter.jobs_service.feign")
public class FeignConfig {
}
