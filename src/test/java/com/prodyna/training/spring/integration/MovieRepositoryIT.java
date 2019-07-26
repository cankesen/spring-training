package com.prodyna.training.spring.integration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.google.common.collect.Sets;
import com.prodyna.training.spring.domain.Act;
import com.prodyna.training.spring.domain.Actor;
import com.prodyna.training.spring.domain.Director;
import com.prodyna.training.spring.domain.Genre;
import com.prodyna.training.spring.domain.Movie;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Ignore
@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class MovieRepositoryIT {

  @PersistenceContext
  private EntityManager entityManager;

  public Long createMovieWithDirectorAndActWithActorsShouldUpdateDB() {

    Movie myTestMovie = Movie.builder().title("MyTestMovie").genre(Genre.ACTION).build();
    Actor actor1 = Actor.builder().name("Actor 1")
        // Implement Task 1.1
        .build();
    Actor actor2 = Actor.builder().name("Actor 2")
        // Implement Task 1.2
        .build();
    Actor actor3 = Actor.builder().name("Actor 3").build();

    Director director = Director.builder().name("Director").build();
    myTestMovie.setDirector(director);

    entityManager.persist(actor1);
    entityManager.persist(actor2);
    entityManager.persist(actor3);

    //set biography after save since shares the same id as actor one-to-one shared key
    // Implement Task 1.3

    Act neo = new Act();
    neo.setActor(actor1);
    neo.setRole("Role 1");

    Act agent = new Act();
    agent.setActor(actor2);
    agent.setRole("Role 2");

    Act murphy = new Act();
    murphy.setActor(actor3);
    murphy.setRole("Role 3");

    Set<Act> acts = Sets.newHashSet(neo, agent, murphy);
    myTestMovie.setActs(acts);

    entityManager.persist(myTestMovie);
    entityManager.flush();

    return myTestMovie.getId();
  }

  /**
   * Must fail due to optional = false
   */
  @Test(expected = PersistenceException.class)
  public void createMovieWithOutDirectorShouldThrowException() {

    Movie myTestMovie = Movie.builder().title("MyTestMovie").genre(Genre.ACTION).build();
    entityManager.persist(myTestMovie);
    entityManager.flush();

  }

  /**
   * Must fail due to nullable = false
   */
  @Test
  public void createMovieWithOutTitleShouldThrowException() {

    //Implement here 3.Task
    //Persist a Movie Entity without title
    //assert that the right exception will be cached

  }

  private int getCountMovie() {
    List<Movie> myTestMovieLoaded = entityManager
        .createNativeQuery("select m.* from Movie m where m.title = ?1 ", Movie.class)
        .setParameter(1, "MyTestMovie")
        .getResultList();
    return myTestMovieLoaded.size();
  }


  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Transactional
  @Test
  public void createShouldBreak() {

    //see Log for rollbacked transaction
    expectedException.expect(NullPointerException.class);
    createMovieWithDirectorAndActWithActorsShouldUpdateDB();
    throw new NullPointerException();

  }

  @Transactional(propagation = Propagation.NEVER)
  @Test(expected = TransactionRequiredException.class)
  public void createWhenNoTransactionShouldFail() {

    int countBefore = getCountMovie();
    createMovieWithDirectorAndActWithActorsShouldUpdateDB();
    int countAfter = getCountMovie();

    assertThat(countAfter - countBefore, is(equalTo(1)));

  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @Test
  public void persistMovieAndChildEntitites() {

    int countBefore = getCountMovie();
    Long movieId = createMovieWithDirectorAndActWithActorsShouldUpdateDB();
    int countAfter = getCountMovie();

    assertThat(countAfter - countBefore, is(equalTo(1)));

    Movie movie = entityManager.find(Movie.class, movieId);

    //Implement here 2. task
    //Update  persistMovieAndChildEntitesTest method and assert following items(using hamcrest)
    //in Movie Entity object
    //Actor 1 is contained by „Role 1“  and has a Car but no Biography
    //Actor 2 is contained by „Role 2“  and has an Address but no Car
    //Actor 3 is contained by „Role 3“  and has a Biography but no Address
  }


}
