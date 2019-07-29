package com.prodyna.training.spring.dao.custom;


import com.prodyna.training.spring.domain.Movie;
import java.util.List;

public interface AppRepositoryCustom {

  public Movie findMovie(Long id);

  public List<Movie> getMovies();

  public Movie createMovie(Movie movie);

}
