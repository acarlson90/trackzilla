package com.aaroncarlson.controller;

import com.aaroncarlson.service.ApplicationService;
import com.aaroncarlson.service.TicketService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(RESTController.class)
public class RESTControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApplicationService applicationService;
    @MockBean
    private TicketService ticketService;

    @Test
    public void testGetAllApplications() throws Exception {

        // Create a GET request with an accept header for application/json
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/applications")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = this.mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"))
                .andReturn();

        // then:
        MockHttpServletResponse response = result.getResponse();
        String json = response.getContentAsString();
        Assert.assertNotNull(json);
        verify(applicationService, times(1)).getAllApplications();
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
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"))
                .andReturn();

        // then:
        MockHttpServletResponse response = result.getResponse();
        String json = response.getContentAsString();
        Assert.assertNotNull(json);
        verify(ticketService, times(1)).getAllTickets();
    }

}
