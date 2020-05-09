package com.aaroncarlson.service;

import com.aaroncarlson.model.Application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;

@SpringBootTest
public class ApplicationServiceTest {

    @Autowired
    private ApplicationService applicationService;

    @Test
    public void contextLoads() throws Exception {
        assertThat(applicationService).isNotNull();
    }

    @Test
    public void testGetAllApplications() throws Exception {
        Iterable<Application> applications = applicationService.getAllApplications();

        assertNotNull(applications);
        assertEquals(3, StreamSupport.stream(applications.spliterator(), false).count());
    }

}
