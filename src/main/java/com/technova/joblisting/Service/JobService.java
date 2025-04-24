package com.technova.joblisting.Service;

import com.technova.joblisting.Repository.JobRepository;
import com.technova.joblisting.model.Job;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }


    public List<Job> getAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        System.out.println("Fetched Jobs: " + jobs);
        return jobs;
    }

    public Job addJob(Job job) {
        return jobRepository.save(job);
    }


}
