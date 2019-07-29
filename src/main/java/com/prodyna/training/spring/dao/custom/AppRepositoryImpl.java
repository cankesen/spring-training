package com.prodyna.training.spring.dao.custom;

import com.prodyna.training.spring.domain.Movie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AppRepositoryImpl implements AppRepositoryCustom {

  @PersistenceContext
  EntityManager entityManager;


  @Override
  public Movie findMovie(Long id) {

    return entityManager.find(Movie.class, id);
  }

  @Override
  public List<Movie> getMovies() {

    return null;

  }

  @Override
  public Movie createMovie(Movie movie) {

    return null;

  }
}
