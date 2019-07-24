package com.prodyna.training.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Primary
@Configuration
@ComponentScan(basePackages = "com.prodyna.training.spring.*")
public class ApplicationConfiguration {


}
