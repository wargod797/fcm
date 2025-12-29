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
    void test_shouldReturnTestObject() throws Exception {
        mockMvc.perform(get("/flight/test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.testText").value("hello"));
    }

    @Test
    void searchFlights_shouldReturnOkAndList() throws Exception {
        mockMvc.perform(get("/flight/search")
                        .param("from", "BLR")
                        .param("to", "DEL")
                        .param("date", "2025-02-01"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void searchFlights_withValidParams_shouldReturnFlights() throws Exception {
        mockMvc.perform(get("/flight/search")
                        .param("from", "BLR")
                        .param("to", "DEL")
                        .param("date", "2025-02-01"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id").value("AI202"))
                .andExpect(jsonPath("$[0].airline").value("Air India"))
                .andExpect(jsonPath("$[0].from").value("BLR"))
                .andExpect(jsonPath("$[0].to").value("DEL"));
    }

    @Test
    void searchFlights_missingFromParam_shouldReturnBadRequest() throws Exception {
        mockMvc.perform(get("/flight/search")
                        .param("to", "DEL")
                        .param("date", "2025-02-01"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void searchFlights_missingToParam_shouldReturnBadRequest() throws Exception {
        mockMvc.perform(get("/flight/search")
                        .param("from", "BLR")
                        .param("date", "2025-02-01"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void searchFlights_missingDateParam_shouldReturnBadRequest() throws Exception {
        mockMvc.perform(get("/flight/search")
                        .param("from", "BLR")
                        .param("to", "DEL"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void searchFlights_invalidDateFormat_shouldReturnBadRequest() throws Exception {
        mockMvc.perform(get("/flight/search")
                        .param("from", "BLR")
                        .param("to", "DEL")
                        .param("date", "invalid-date"))
                .andExpect(status().isBadRequest());
    }
}
