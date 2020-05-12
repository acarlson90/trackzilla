package com.aaroncarlson.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class PeopleHealthIndicator implements HealthIndicator {

    private final String message_key = "PeopleService";

    @Override
    public Health health() {
        if (!isRunningPeopleService()) {
            return Health.down().withDetail(message_key, "Not Available").build();
        }
        return Health.up().withDetail(message_key, "Available").build();
    }

    private Boolean isRunningPeopleService() {
        Boolean isRunning = false;
        // Addd real logic here to test if PeopleService is running; skipped for demo purposes
        return  isRunning;
    }

}
