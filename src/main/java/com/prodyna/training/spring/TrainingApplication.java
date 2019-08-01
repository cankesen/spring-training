package com.prodyna.training.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class TrainingApplication {

  public static void main(String[] args) {

    SpringApplication.run(TrainingApplication.class, args);
    logAllLevels("Spring Training");
  }

  static void logAllLevels(final String value) {
    log.trace(" information - {}", value);
    log.debug(" debug - {}", value);
    log.info(" info - {}", value);
    log.warn(" warn - {}", value);
    log.error(" error - {}", value);
  }

}
