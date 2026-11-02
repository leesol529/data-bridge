package com.example.backend_study_platform.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class HealthChkController {
    @GetMapping("/health")
    public Map<String, String> healthChk(){
        return Map.of(
            "status", "UP",
            "message", "Backend Study Platform is running"
        );
    }

}
