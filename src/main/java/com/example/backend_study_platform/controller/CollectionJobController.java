package com.example.backend_study_platform.controller;

import com.example.backend_study_platform.dto.CollectionJobResponse;
import com.example.backend_study_platform.service.CollectionJobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/collection-jobs")
public class CollectionJobController {

    private final CollectionJobService service;

    public CollectionJobController(CollectionJobService service){
        this.service = service;
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<CollectionJobResponse> getJob(@PathVariable String jobId){
        Optional<CollectionJobResponse> result = service.findById(jobId);
        if(result.isEmpty()){
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(result.get());
        }
    }
}
