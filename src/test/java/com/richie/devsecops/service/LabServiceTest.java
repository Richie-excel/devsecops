package com.richie.devsecops.service;

import com.richie.devsecops.model.ServiceInfo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LabServiceTest {
    private final LabService labService = new LabService();
    @Test
    void getLabById_includesIdInName() {
        ServiceInfo info = labService.getLabById(7L);

        assertEquals(7L, info.id());
        assertEquals("Platform-lab-7", info.name());
        assertEquals("UP", info.status());
    }

    @Test
    void greet_usesGivenName() {
        assertEquals("Hello, Richie", labService.greet("Richie"));
    }
}
