package com.technova.joblisting.controller;


import com.technova.joblisting.Repository.SearchRepository;
import com.technova.joblisting.Service.JobService;
import com.technova.joblisting.model.Job;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JobController {
    private final JobService jobService;

    @Autowired
   SearchRepository repo;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @Operation(summary = "Get all job")
    @GetMapping(value = "/jobs",produces = "application/json")
    public List<Job> getJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/jobs/{text}")
    public List<Job> search(@RequestParam String text)
    {
        return repo.findByText(text);
    }

    @PostMapping
    @Operation(summary = "Add a new job")
    public Job addJob(@RequestBody Job job) {
        return jobService.addJob(job);
    }

}
