package com.richie.devsecops.service;

import com.richie.devsecops.model.ServiceInfo;
import org.springframework.stereotype.Service;

@Service
public class LabService {
    public ServiceInfo getLab() {
        return new ServiceInfo(1L, "Platform-lab", "UP");
    }

    public ServiceInfo getLabById(long id) {
        return new ServiceInfo(id, "Platform-lab-" + id, "UP");
    }

    public String greet(String name) {
        return "Hello, " + name;
    }
}