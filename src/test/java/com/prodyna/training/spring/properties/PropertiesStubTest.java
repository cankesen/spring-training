package com.prodyna.training.spring.properties;

import com.prodyna.training.spring.config.MoviesConfiguration;
import com.prodyna.training.spring.domain.Movie;
import com.prodyna.training.spring.factory.MovieFactory;
import com.prodyna.training.spring.factory.MovieFactoryImpl;
import com.prodyna.training.spring.factory.MovieFactoryStub;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("stubtest")
@SpringBootTest(classes = {
    MoviesConfiguration.class,
    MovieFactory.class,
    MovieFactoryStub.class,
    MovieFactoryImpl.class
})
@EnableConfigurationProperties(MoviesConfiguration.class)
public class PropertiesStubTest {

  @Autowired
  MovieFactory movieFactory;

  @Test
  public void givenBean_inContext() {

    List<Movie> movieList = movieFactory.getMovies();

    Assert.assertEquals(movieList.size(), 2);
    Assert.assertEquals(movieList.get(0).getTitle(), "Green Mile");

  }

}
