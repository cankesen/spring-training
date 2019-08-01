package com.prodyna.training.spring.dao.custom;

import com.prodyna.training.spring.domain.Actor;
import com.prodyna.training.spring.domain.Movie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AppRepositoryImpl implements AppRepositoryCustom {

  @PersistenceContext
  EntityManager entityManager;


  /**
   * Generic find of Entity Manager
   * @param id
   * @return
   */
  @Override
  public Movie findMovie(Long id) {

    return entityManager.find(Movie.class, id);

  }

  /**
   * Create a query
   * @return
   */
  @Override
  public List<Movie> getMovies() {

    return entityManager
        .createQuery("select m from Movie m", Movie.class)
        .getResultList();

  }

  /**
   * Here we should actually use a DTO, but for the ease of implementation in training hands-on
   * we use the entity itself
   * @param movie
   * @return
   */
  @Override
  public Movie createMovie(Movie movie) {

    movie.getActs().stream().map(act-> act.getActor()).forEach(entityManager::persist);
    entityManager.persist(movie);
    entityManager.flush();
    return movie;

  }

}
