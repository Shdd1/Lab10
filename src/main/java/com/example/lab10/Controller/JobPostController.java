package com.example.lab10.Controller;

import com.example.lab10.ApiResponse.ApiResponse;
import com.example.lab10.Model.JobPost;
import com.example.lab10.Model.User;
import com.example.lab10.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jobpost")
@RequiredArgsConstructor
public class JobPostController {
    private final JobPostService jobPostService;
    @GetMapping("/get")
    public ResponseEntity getJob(){
        return ResponseEntity.status(200).body(jobPostService.getJop());

    }
    @PostMapping("/add")
    public ResponseEntity addJob(@Valid @RequestBody JobPost jobPost, Errors errors){
        if(errors.hasErrors()){
            String massege=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        jobPostService.addJop(jobPost);
        return ResponseEntity.status(200).body(new ApiResponse("is added"));


    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateJob(@PathVariable Integer id, @Valid@RequestBody JobPost jobPost, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated=jobPostService.updateJop(id,jobPost);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("User updated"));

        }
        return ResponseEntity.status(400).body(new ApiResponse("Not found"));
    }
    @DeleteMapping("/delete/{id}")
    private ResponseEntity deleteJob(@PathVariable Integer id){
        boolean isDeleted=jobPostService.deleteJop(id);
        if(isDeleted){
            return ResponseEntity.status(400).body(new ApiResponse("IS deleted"));
        }
        return ResponseEntity.status(200).body(new ApiResponse("not found"));
    }
}
