package com.prodyna.training.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HealthCheck implements HealthIndicator {

    @Value("${intValue}")
    int errorCode;

    @Override
    public Health health() {

        if (errorCode != 0) {
            return Health.down()
                    .withException(new NullPointerException("test"))
                    .withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }

}
