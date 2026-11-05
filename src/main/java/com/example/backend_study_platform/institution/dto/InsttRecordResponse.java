package com.example.backend_study_platform.institution.dto;

import java.util.List;

public record InsttRecordResponse(
        String institutionCode,
        List<InsttRecord> records,
        int count
) {}
