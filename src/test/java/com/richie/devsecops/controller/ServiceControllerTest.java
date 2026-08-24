package com.richie.devsecops.controller;

import com.richie.devsecops.model.ServiceInfo;
import com.richie.devsecops.service.LabService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ServiceController.class)
public class ServiceControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private LabService labService;

    @Test
    @WithMockUser
    void getService_returnsJson() throws Exception {
        when(labService.getLab()).thenReturn(new ServiceInfo(1L, "Platform-lab", "UP"));
        mockMvc.perform(get("/api/service"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Platform-lab"))
                .andExpect(jsonPath("$.status").value("UP"));
    }
}
