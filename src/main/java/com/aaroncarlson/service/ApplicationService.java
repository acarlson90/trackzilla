package com.aaroncarlson.service;

import com.aaroncarlson.exception.ResourceNotFoundException;
import com.aaroncarlson.model.Application;
import com.aaroncarlson.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Application getApplicationById(long id) {
        return applicationRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Application", "id", String.valueOf(id))
        );
    }

}
