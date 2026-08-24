package com.richie.devsecops.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
    @GetMapping("/status")
    public String status() {
        return "System is running smoothly.";
    }

    @GetMapping("/health")
    public String health() {
        return "UP";
    }
}
