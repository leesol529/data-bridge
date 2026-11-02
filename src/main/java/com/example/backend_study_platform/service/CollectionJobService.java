package com.example.backend_study_platform.service;

import com.example.backend_study_platform.dto.CollectionJobResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CollectionJobService {
    public Optional<CollectionJobResponse> findById(String jobId){ // Optional 값이 있을 수도 없을수도 있음
        if("JOB-001".equals(jobId)){
            CollectionJobResponse response = new CollectionJobResponse(
                    "JOB-001",
                    "BANK-A",
                    "COMPLETED",
                    1000,
                    1000);

            return Optional.of(response); // 값 존재
        }

        return Optional.empty(); // 값 없음
    }
}
