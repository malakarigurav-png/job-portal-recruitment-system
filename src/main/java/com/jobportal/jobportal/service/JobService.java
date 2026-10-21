package com.jobportal.jobportal.service;

import com.jobportal.jobportal.entity.Job;
import com.jobportal.jobportal.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
    public List<Job> getJobsByRecruiterId(Long recruiterId) {
    return jobRepository.findByRecruiterId(recruiterId);
} 
    public Job getJobById(Long jobId) {
    return jobRepository.findById(jobId).orElse(null);
} 
}