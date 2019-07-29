package com.prodyna.training.spring.integration;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Sets;
import com.prodyna.training.spring.domain.Act;
import com.prodyna.training.spring.domain.Actor;
import com.prodyna.training.spring.domain.Director;
import com.prodyna.training.spring.domain.Genre;
import com.prodyna.training.spring.domain.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MovieResourceMockMvcIT {

  @Autowired
  private MockMvc mvc;

  @Test
  public void testGetMovies() throws Exception {

    //implement

  }

  @Test
  public void testGetMoviesPojo() throws Exception {

    //implement

  }


  @Test
  public void testCreateMovie() throws Exception {

    //Use the movie as the request body
    Actor actor = Actor.builder().name("TestActor").build();
    Director director = Director.builder().name("TestDirector").build();
    Movie movie = Movie.builder().director(director).title("TestMovie").genre(Genre.ACTION).build();
    Act act = Act.builder().actor(actor).movie(movie).role("TestRole").build();
    movie.setActs(Sets.newHashSet(act));



  }

}
