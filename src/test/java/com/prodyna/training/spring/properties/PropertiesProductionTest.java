package com.prodyna.training.spring.properties;

import com.prodyna.training.spring.config.MoviesConfiguration;
import com.prodyna.training.spring.factory.MovieFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("profile")
@SpringBootTest(classes = {
    MoviesConfiguration.class,
    MovieFactory.class
})
public class PropertiesProductionTest {

//  @Autowired
//  private MovieFactory movieFactory;


  @Test
//      (expected = RuntimeException.class)
  public void productionBeanThrowException() {

//    movieFactory.getMovies();

  }

}
