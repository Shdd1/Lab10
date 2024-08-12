package com.example.lab10.Service;

import com.example.lab10.Model.JobApplication;
import com.example.lab10.Model.JobPost;
import com.example.lab10.Model.User;
import com.example.lab10.Repository.JobApplicationRepository;
import com.example.lab10.Repository.JobPostRepository;
import com.example.lab10.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;
    private final JobPostRepository jobPostRepository;
    private final UserRepository userRepository;

    public List<JobApplication> getJopApp(){
        return jobApplicationRepository.findAll();
    }


    public boolean updateJopApp(Integer id,JobApplication jobApplication){
            JobApplication j=jobApplicationRepository.getById(id);
        if(j==null){
            return false;
        }
        j.setJobPostId(jobApplication.getJobPostId());
        j.setUserId(jobApplication.getUserId());
      jobApplicationRepository.save(j);
        return true;
    }

    //10. Apply For Job: Adds a new job application to the system.

    public boolean applyJob(JobApplication jobApplication){
       if(userRepository.existsById(jobApplication.getUserId())){
           if(jobPostRepository.existsById(jobApplication.getJobPostId())){
               jobApplicationRepository.save(jobApplication);
               return true;
           }
       }
         return false;
    }
    //11. Withdraw Job Application: Deletes a job application from the system
    public boolean deleteJobApply(Integer id){
        JobApplication j=jobApplicationRepository.getById(id);
        if(j==null){
            return false;
        }
        jobApplicationRepository.delete(j);
        return true;
    }

}
