package com.aaroncarlson.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@SpringBootTest
public class TicketControllerTest {

    @Autowired
    private TicketController ticketController;

    @Mock
    private Model model;

    @Test
    public void contextLoads() throws Exception {
        assertThat(ticketController).isNotNull();
    }

    @Test
    public void testGetTicketsPage() throws Exception {
        String returnValue = ticketController.getTickets(model);
        assertEquals("tickets", returnValue);
    }

}
