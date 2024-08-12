package com.example.lab10.Controller;

import com.example.lab10.ApiResponse.ApiResponse;
import com.example.lab10.Model.JobApplication;
import com.example.lab10.Model.JobPost;
import com.example.lab10.Service.JobApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jobapp")
@RequiredArgsConstructor
public class JobApplicationController {
    private final JobApplicationService jobApplicationService;
    @GetMapping("/get")
    public ResponseEntity getJobApp(){
        return ResponseEntity.status(200).body(jobApplicationService.getJopApp());

    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateJobApp(@PathVariable Integer id, @Valid@RequestBody JobApplication jobApplication, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated=jobApplicationService.updateJopApp(id,jobApplication);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("User updated"));

        }
        return ResponseEntity.status(400).body(new ApiResponse("Not found"));
    }
   @PostMapping ("/apply")
    public ResponseEntity applyJobApp(@Valid@RequestBody JobApplication jobApplication, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isadd=jobApplicationService.applyJob(jobApplication);
        if(isadd){
            return ResponseEntity.status(200).body(new ApiResponse("job added"));

        }
        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }
    @DeleteMapping("/delete/{id}")
    private ResponseEntity deleteApllyJob(@PathVariable Integer id){
        boolean isDeleted=jobApplicationService.deleteJobApply(id);
        if(isDeleted){
            return ResponseEntity.status(400).body(new ApiResponse("IS deleted"));
        }
        return ResponseEntity.status(200).body(new ApiResponse("not found"));
    }

}
