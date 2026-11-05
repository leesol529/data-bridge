package com.example.backend_study_platform.collection.controller;

import com.example.backend_study_platform.collection.dto.CollectionJobResponse;
import com.example.backend_study_platform.collection.service.CollectionJobService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(com.example.backend_study_platform.collection.controller.CollectionJobController.class)
public class CollectionJobControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CollectionJobService service;

    @Test
    void 작업_존재시_200_반환() throws Exception{
        CollectionJobResponse response = new CollectionJobResponse(
                "JOB-001",
                "BANK-A",
                "COMPLETED",
                1000,
                1000
        );

        given(service.findById("JOB-001")).willReturn(Optional.of(response));

        mockMvc.perform(get("/api/v1/collection-jobs/JOB-001"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.jobId").value("JOB-001"))
                .andExpect(jsonPath("$.insttCd").value("BANK-A"))
                .andExpect(jsonPath("$.status").value("COMPLETED"));
    }

    @Test
    void 작업_미존재시_404_반환() throws Exception{
        given(service.findById("JOB-999")).willReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/collection-jobs/JOB-999"))
                .andExpect(status().isNotFound());
    }
}
