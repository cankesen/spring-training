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


  @Override
  public Movie findMovie(Long id) {

    return entityManager.find(Movie.class, id);

  }

  @Override
  public List<Movie> getMovies() {

    return entityManager
        .createQuery("select m from Movie m", Movie.class)
        .getResultList();

  }

  @Override
  public Movie createMovie(Movie movie) {

    // when testing we may use existing actors and we post the whole movie object
    // with all sub-elements. So we check for the actor if it already exists, if yes
    // get the existing actor from peristence context

    // so any time you pass a persisted entity to persist method, you will get detached entity
    //passed to persist exception. To Avoid it you should use the attached and perirsted entity by
    // getting it from persistence context

    // this code demonstrates the case only for actor! if you pass a director which is already persisted
    // the exception will be thrown
    movie.getActs().stream().forEach(act -> {
      if(act.getActor().getId() != null){
        act.setActor(entityManager.find(Actor.class, act.getActor().getId()));
      }
    });


    movie.getActs().stream().map(act-> act.getActor()).forEach(entityManager::persist);
    entityManager.persist(movie);
    entityManager.flush();
    return movie;

  }
}
