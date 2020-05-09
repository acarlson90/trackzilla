package com.aaroncarlson.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@SpringBootTest
public class ApplicationControllerTest {

    @Autowired
    private ApplicationController applicationController;

    @Mock
    private Model model;

    @Test
    public void contextLoads() throws Exception {
        assertThat(applicationController).isNotNull();
    }

    @Test
    public void testGetApplicationsPage() throws Exception {
        String returnValue = applicationController.getApplications(model);
        assertEquals("applications", returnValue);
    }

}
