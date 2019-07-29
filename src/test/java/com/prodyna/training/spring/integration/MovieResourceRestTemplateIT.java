package com.prodyna.training.spring.integration;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Sets;
import com.prodyna.training.spring.domain.Act;
import com.prodyna.training.spring.domain.Actor;
import com.prodyna.training.spring.domain.Director;
import com.prodyna.training.spring.domain.Genre;
import com.prodyna.training.spring.domain.Movie;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MovieResourceRestTemplateIT {


  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void testGetMoviesAsStringResponse() throws IOException {

    String body = this.restTemplate.getForObject("//api/v1/movies", String.class);

    Movie[] movies = new ObjectMapper().readValue(body, Movie[].class);

    assertThat(movies.length, is(greaterThan(0)));

  }

  @Test
  public void testGetMovieAsEntityResponse() {

    ResponseEntity<Movie> movieResponse = this.restTemplate
        .getForEntity("//api/v1/movies/1", Movie.class);

    assertThat(movieResponse.getBody(), is(not(equalTo(null))));
    assertThat(movieResponse.getBody().getTitle(), is("Matrix"));

  }

  @Test
  public void testCreateMovie() throws Exception {

    Actor actor = Actor.builder().name("TestActor").build();
    Director director = Director.builder().name("TestDirector").build();
    Movie movie = Movie.builder().director(director).title("TestMovie").genre(Genre.ACTION).build();
    Act act = Act.builder().actor(actor).movie(movie).role("TestRole").build();
    movie.setActs(Sets.newHashSet(act));

    ResponseEntity<Movie> movieEntityLoaded = this.restTemplate
        .postForEntity("//api/v1/movies", new HttpEntity<>(movie), Movie.class);

    Movie movieLoaded = movieEntityLoaded.getBody();

    assertThat(movieLoaded.getId(), is(notNullValue()));
    assertThat(movieLoaded.getActs().size(), is(1));

    Actor actorLoaded = movieLoaded.getActs().stream().findFirst().get().getActor();
    assertThat(actorLoaded.getId(), is(notNullValue()));
    assertThat(actorLoaded.getName(), is("TestActor"));

    assertThat(movieLoaded.getDirector().getId(), is(notNullValue()));
    assertThat(movieLoaded.getDirector().getName(), is("TestDirector"));

  }


}
