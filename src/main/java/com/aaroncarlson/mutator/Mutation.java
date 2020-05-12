package com.aaroncarlson.mutator;

import com.aaroncarlson.model.Application;
import com.aaroncarlson.service.ApplicationService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    private ApplicationService applicationService;

    public Mutation(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    public Application createApplication(String name,
                                         String description,
                                         String owner) {
        Application application = new Application(name, description, owner);
        applicationService.createApplication(application);
        return application;
    }

    public Application updateApplication(Long id,
                                         String name,
                                         String description,
                                         String owner) {
        Application application = new Application(name, description, owner);
        applicationService.updateApplication(id, application);

        return applicationService.getApplicationById(id);
    }

    public boolean deleteApplication(Long id) {
        return applicationService.deleteApplication(id);
    }

}
