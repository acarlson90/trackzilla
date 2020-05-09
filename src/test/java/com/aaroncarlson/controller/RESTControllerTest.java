package com.aaroncarlson.controller;

import com.aaroncarlson.model.Application;
import com.aaroncarlson.service.ApplicationService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RESTControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApplicationService applicationService;

    @Test
    public void testGetAllApplications() throws Exception {

        // Create a GET request with an accept header for application/json
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/applications")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = this.mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        // then:
        MockHttpServletResponse response = result.getResponse();
        String json = response.getContentAsString();
        Assert.assertNotNull(json);
    }

    @Test
    public void testGetAllTickets() throws Exception {

        // Create a GET request with an accept header for application/json
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/tickets")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = this.mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        // then:
        MockHttpServletResponse response = result.getResponse();
        String json = response.getContentAsString();
        Assert.assertNotNull(json);
    }

}
