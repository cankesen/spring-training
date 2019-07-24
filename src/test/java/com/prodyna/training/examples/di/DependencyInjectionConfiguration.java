package com.prodyna.training.examples.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DependencyInjectionConfiguration {

  @Bean
  public String name() {
    return "I Am a Repo";
  }

  @Bean
  public Dao dao() {
    return new Dao(name());
  }

  @Bean
  public Service service() {
    return new Service(dao());
  }

}
