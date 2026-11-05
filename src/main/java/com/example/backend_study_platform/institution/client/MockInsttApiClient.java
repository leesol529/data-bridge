package com.example.backend_study_platform.institution.client;

import com.example.backend_study_platform.institution.dto.InsttRecordResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class MockInsttApiClient {
    private final RestClient restClient;

    public MockInsttApiClient(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("http://localhost:8080")
                .build();
    }

    public InsttRecordResponse fetchRecords(String institutionCode) {

        return restClient.get()
                .uri("/mock-api/v1/institutions/{institutionCode}/records",
                        institutionCode
                )
                .retrieve()
                .body(InsttRecordResponse.class);

    }
}
