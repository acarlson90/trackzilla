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

    public Long getCount() {
        return applicationRepository.count();
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Application getApplicationById(final Long id) {
        return applicationRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Application", "id", String.valueOf(id))
        );
    }

    public void createApplication(final Application application) {
        applicationRepository.save(application);
    }

    public void updateApplication(final Long id,
                                  final Application applicationUpdate) {
        Application application = getApplicationById(id);

        if (!application.equals(applicationUpdate)) {
            application.setName(applicationUpdate.getName());
            application.setDescription(applicationUpdate.getDescription());
            application.setOwner(applicationUpdate.getOwner());
        }

        applicationRepository.saveAndFlush(application);
    }

    public boolean deleteApplication(final Long id) {
        Application application = getApplicationById(id);
        applicationRepository.delete(application);
        return true;
    }

}
