package com.example.backend_study_platform.collection.service;

import com.example.backend_study_platform.collection.dto.CollectionJobResponse;
import com.example.backend_study_platform.institution.client.MockInsttApiClient;
import com.example.backend_study_platform.institution.dto.InsttRecordResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CollectionJobService {

    private final MockInsttApiClient client;

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

    public Optional<InsttRecordResponse> getRecords(
            String jobId) {

        return findById(jobId)
                .map(job ->
                        client.fetchRecords(
                                job.insttCd()
                        )
                );
    }
}
