package com.jobportal.jobportal.controller;

import com.jobportal.jobportal.entity.Job;
import com.jobportal.jobportal.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return jobService.saveJob(job);
    }

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }
    @GetMapping("/{jobId}")
public Job getJobById(@PathVariable Long jobId) {
    return jobService.getJobById(jobId);
} 
@GetMapping("/recruiter/{recruiterId}")
public List<Job> getJobsByRecruiterId(@PathVariable Long recruiterId) {
    return jobService.getJobsByRecruiterId(recruiterId);
}  
}