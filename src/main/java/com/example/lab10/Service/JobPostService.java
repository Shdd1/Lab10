package com.example.lab10.Service;

import com.example.lab10.Model.JobPost;
import com.example.lab10.Model.User;
import com.example.lab10.Repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {
    private final JobPostRepository jobPostRepository;
    public List<JobPost> getJop(){
        return jobPostRepository.findAll();
    }
    public void addJop(JobPost jobPost){
        jobPostRepository.save(jobPost);
    }

    public boolean updateJop(Integer id,JobPost jobPost){
        JobPost j=jobPostRepository.getById(id);
        if(j==null){
            return false;
        }
      j.setTitle(jobPost.getTitle());
        j.setSalary(jobPost.getSalary());
        j.setPostingDate(jobPost.getPostingDate());
        j.setLocation(jobPost.getLocation());
        j.setDescription(jobPost.getDescription());
        jobPostRepository.save(j);
        return true;
    }
    public boolean deleteJop(Integer id){
        JobPost j=jobPostRepository.getById(id);
        if(j==null){
            return false;
        }
        jobPostRepository.delete(j);
        return true;
    }

}
