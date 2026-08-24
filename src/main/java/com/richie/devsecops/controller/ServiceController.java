package com.richie.devsecops.controller;

import com.richie.devsecops.model.ServiceInfo;
import com.richie.devsecops.service.LabService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
    private final LabService labService;

    public ServiceController(LabService labService) {
        this.labService = labService;
    }

    @GetMapping("/api/service")
    public ServiceInfo getLab() {
        return labService.getLab();
    }

    @GetMapping("/api/hello")
    public String greet(@RequestParam(defaultValue = "engineer") String name) {
       return labService.greet(name);
    }

    @GetMapping("/api/service/{id}")
    public ServiceInfo byId(@PathVariable Long id) {
        return labService.getLabById(id);
    }
}
