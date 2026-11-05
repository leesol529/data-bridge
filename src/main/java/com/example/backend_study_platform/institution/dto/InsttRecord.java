package com.example.backend_study_platform.institution.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record InsttRecord(
        String externalId,
        LocalDate transactionDate,
        BigDecimal amount,
        String currency
) {
}
