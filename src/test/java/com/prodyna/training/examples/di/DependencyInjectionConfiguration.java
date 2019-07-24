package com.prodyna.training.examples.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.prodyna.training.examples.di")
public class DependencyInjectionConfiguration {

  @Bean
  public String name() {
    return "I Am a Repo";
  }


}
