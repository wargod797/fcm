package com.travel.fcm.ControllerTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
class FlightControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void searchFlights_shouldReturnOkAndList() throws Exception {
        mockMvc.perform(get("/flights/search")
                        .param("from", "BLR")
                        .param("to", "DEL")
                        .param("date", "2025-02-01"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
}
