package com.jobportal.jobportal.service;

import com.jobportal.jobportal.entity.Application;
import com.jobportal.jobportal.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Application saveApplication(Application application) {
        return applicationRepository.save(application);
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }
    public List<Application> getApplicationsByUserId(Long userId) {
    return applicationRepository.findByUserId(userId);
} 
public List<Application> getApplicationsByJobId(Long jobId) {
    return applicationRepository.findByJobId(jobId);
} 
public Application updateApplicationStatus(Long applicationId, String status) {

    Application application =
            applicationRepository.findById(applicationId).orElse(null);

    if (application == null) {
        return null;
    }

    application.setStatus(status);

    return applicationRepository.save(application);
} 
}