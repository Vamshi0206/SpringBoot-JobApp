package com.example.SpringRest;

import com.example.SpringRest.model.JobPost;
import com.example.SpringRest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs()
    {
        return service.getAllJobs();
    }

    @PostMapping("addJobs")
    public void addJob(@RequestBody JobPost jobPost)
    {
        service.addJob(jobPost);

    }

    @PutMapping("/updateJob/{postId}")
    public JobPost updateJob(@PathVariable int postId,@RequestBody JobPost jobPost)
    {
        return service.updateJob(postId,jobPost);
    }

    @DeleteMapping("/deleteJob/{postId}")
    public String deleteJob(@PathVariable int postId)
    {
        service.deleteJob(postId);
        return "Deleted successfully";
    }



}
