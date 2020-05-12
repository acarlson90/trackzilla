package com.aaroncarlson.resolver;

import com.aaroncarlson.model.Application;
import com.aaroncarlson.service.ApplicationService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    private ApplicationService applicationService;

    public Query(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    public Long applicationCount() {
        return  applicationService.getCount();
    }

}
