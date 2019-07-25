package com.prodyna.training.spring.factory;

import com.prodyna.training.spring.domain.Movie;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("production")
@Component
public class MovieFactoryImpl implements MovieFactory {

  public List<Movie> getMovies(){
      throw new RuntimeException("Not Supported");
  }


}
