package com.prodyna.training.spring.integration;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import com.prodyna.training.spring.dao.custom.AppRepository;
import com.prodyna.training.spring.domain.Movie;
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

    //use both repository methods
    //Long count = appRepository.countAllByPrizes_Movie_Title("Matrix");

  }


}
