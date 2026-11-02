package com.example.backend_study_platform.dto;

public record CollectionJobResponse(
        String jobId,
        String insttCd,
        String status,
        int reqCnt,
        int sucCnt
) {
}
