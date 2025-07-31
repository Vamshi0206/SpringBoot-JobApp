package com.example.SpringRest.service;

import com.example.SpringRest.model.JobPost;
import com.example.SpringRest.repo.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository repo;

    public List<JobPost> getAllJobs() {
        return repo.findAll();
    }

    public void addJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public JobPost updateJob(int postId,JobPost updatedJob) {
        Optional<JobPost> existingJob = repo.findById(postId);

        if (existingJob.isPresent()) {
            JobPost job = existingJob.get();
            job.setPostProfile(updatedJob.getPostProfile());
            job.setPostDesc(updatedJob.getPostDesc());
            job.setReqExp(updatedJob.getReqExp());
            job.setTechStack(updatedJob.getTechStack());

            return repo.save(job); // Updates the existing job
        } else {
            throw new RuntimeException("JobPost not found with id: " + postId);
        }
    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }
}
