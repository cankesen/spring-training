package com.prodyna.training.spring.integration;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import com.google.common.collect.Sets;
import com.prodyna.training.spring.dao.ActorRepository;
import com.prodyna.training.spring.dao.custom.AppRepository;
import com.prodyna.training.spring.domain.Act;
import com.prodyna.training.spring.domain.Actor;
import com.prodyna.training.spring.domain.Car;
import com.prodyna.training.spring.domain.Director;
import com.prodyna.training.spring.domain.Genre;
import com.prodyna.training.spring.domain.Movie;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomRepositoryIT {

  @Autowired
  private AppRepository appRepository;


  @Test
  public void findMovieByIdTest() {

    Movie movie = appRepository.findMovie(1L);
    assertThat(movie, is(not(nullValue())));

    //you use both repository methods custom and from spring dao ex.:
    //Long count = appRepository.countAllByPrizes_Movie_Title("Matrix");

  }

  @Ignore
  @Test
  public void testCreateMovieWithNewActor(){
    Actor actor1 = Actor.builder().name("Actor 1")
        .car(Car.builder().brand("Test Brand").model("Test Model").build())
        .build();

    Director director = Director.builder().name("Director").build();
    Movie myTestMovie = Movie.builder().director(director).title("MyTestMovie").genre(Genre.ACTION).build();
    Act act = Act.builder().actor(actor1).movie(myTestMovie).role("testRole").build();
    myTestMovie.setActs(Sets.newHashSet(act));

    myTestMovie = appRepository.createMovie(myTestMovie);

    assertThat(myTestMovie.getId(), is(notNullValue()));
    assertThat(myTestMovie.getActs().size(), is(1));
    assertThat(myTestMovie.getActs().stream().findFirst().get().getActor().getId(), is(notNullValue()));

  }

  @Ignore
  @Test
  public void testCreateMovieWithExistingActor(){
//    Actor actor1 = actorRepository.getOne(1L);
    Actor actor1 =  Actor.builder().id(1L).build();

    Director director = Director.builder().name("Director").build();
    Movie myTestMovie = Movie.builder().director(director).title("MyTestMovie").genre(Genre.ACTION).build();
    Act act = Act.builder().actor(actor1).movie(myTestMovie).role("testRole").build();
    myTestMovie.setActs(Sets.newHashSet(act));

    myTestMovie = appRepository.createMovie(myTestMovie);

    assertThat(myTestMovie.getId(), is(notNullValue()));
    assertThat(myTestMovie.getActs().size(), is(1));
    assertThat(myTestMovie.getActs().stream().findFirst().get().getActor().getName(), is("Keanu Reeves"));

  }


}
