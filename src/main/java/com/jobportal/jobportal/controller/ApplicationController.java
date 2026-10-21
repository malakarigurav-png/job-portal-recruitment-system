package com.jobportal.jobportal.controller;

import com.jobportal.jobportal.entity.Application;
import com.jobportal.jobportal.service.ApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public Application createApplication(@RequestBody Application application) {
        return applicationService.saveApplication(application);
    }

    @GetMapping
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }
    @GetMapping("/user/{userId}")
public List<Application> getApplicationsByUserId(@PathVariable Long userId) {
    return applicationService.getApplicationsByUserId(userId);
} 
@GetMapping("/job/{jobId}")
public List<Application> getApplicationsByJobId(@PathVariable Long jobId) {
    return applicationService.getApplicationsByJobId(jobId);
} 
@PutMapping("/{applicationId}/status")
public Application updateApplicationStatus(
        @PathVariable Long applicationId,
        @RequestParam String status) {

    return applicationService.updateApplicationStatus(
            applicationId,
            status
    );
} 
}