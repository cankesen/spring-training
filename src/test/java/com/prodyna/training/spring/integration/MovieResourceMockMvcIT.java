package com.prodyna.training.spring.integration;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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

    mvc.perform(get("/api/v1/movies")
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content()
            .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$[0].id", is(1)));

  }

  @Test
  public void testGetMoviesPojo() throws Exception {

    MvcResult mvcResult = mvc.perform(get("/api/v1/movies")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andReturn();

    Movie[] movies = new ObjectMapper().readValue(mvcResult.getResponse()
        .getContentAsByteArray(), Movie[].class);

    assertThat(movies.length, is(greaterThan(0)));

  }


  @Test
  public void testCreateMovie() throws Exception {

    Actor actor = Actor.builder().name("TestActor").build();
    Director director = Director.builder().name("TestDirector").build();
    Movie movie = Movie.builder().director(director).title("TestMovie").genre(Genre.ACTION).build();
    Act act = Act.builder().actor(actor).movie(movie).role("TestRole").build();
    movie.setActs(Sets.newHashSet(act));

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setSerializationInclusion(Include.NON_NULL);
    String movieJson = objectMapper.writeValueAsString(movie);

    MvcResult mvcResult = mvc.perform(post("/api/v1/movies")
        .content(movieJson)
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andReturn();

    Movie movieLoaded = objectMapper.readValue(mvcResult.getResponse()
        .getContentAsByteArray(), Movie.class);

    assertThat(movieLoaded.getId(), is(notNullValue()));
    assertThat(movieLoaded.getActs().size(), is(1));

    Actor actorLoaded = movieLoaded.getActs().stream().findFirst().get().getActor();
    assertThat(actorLoaded.getId(), is(notNullValue()));
    assertThat(actorLoaded.getName(), is("TestActor"));

    assertThat(movieLoaded.getDirector().getId(), is(notNullValue()));
    assertThat(movieLoaded.getDirector().getName(), is("TestDirector"));

  }

}
