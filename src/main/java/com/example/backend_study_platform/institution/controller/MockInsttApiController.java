package com.example.backend_study_platform.institution.controller;

import com.example.backend_study_platform.institution.dto.InsttRecord;
import com.example.backend_study_platform.institution.dto.InsttRecordResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/mock-api/v1/institutions")
public class MockInsttApiController {

    @GetMapping("/{institutionCode}/records")
    public InsttRecordResponse getRecords(
            @PathVariable String institutionCode) {

        List<InsttRecord> records =
                IntStream.rangeClosed(1, 5)
                        .mapToObj(i -> new InsttRecord(
                                "TX-%03d".formatted(i),
                                LocalDate.of(2026, 11, 5),
                                BigDecimal.valueOf(10000L * i),
                                "KRW"
                        ))
                        .toList();

        return new InsttRecordResponse(
                institutionCode,
                records,
                records.size()
        );
    }
}