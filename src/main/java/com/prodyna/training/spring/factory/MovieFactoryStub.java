package com.prodyna.training.spring.factory;

import com.prodyna.training.spring.config.MoviesConfiguration;
import com.prodyna.training.spring.domain.Movie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("stub")
@Component
public class MovieFactoryStub implements MovieFactory {

  @Autowired
  private MoviesConfiguration moviesConfiguration;

  public MovieFactoryStub(@Autowired MoviesConfiguration moviesConfiguration){
    this.moviesConfiguration = moviesConfiguration;
  }

  @Override
  public List<Movie> getMovies() {
    return moviesConfiguration.getMovies();
  }
}
