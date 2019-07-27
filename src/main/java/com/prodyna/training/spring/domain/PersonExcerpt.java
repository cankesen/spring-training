package com.prodyna.training.spring.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "personExcerpt", types = {Person.class})
public interface PersonExcerpt {

    String getName();

    Address getAddress();

    @Value("#{target.car != null ? target.car.toString() : 'no car'}")
    String getCar();


}
