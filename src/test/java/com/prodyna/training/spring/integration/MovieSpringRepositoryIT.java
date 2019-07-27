package com.prodyna.training.spring.integration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import com.prodyna.training.spring.dao.MovieRepository;
import com.prodyna.training.spring.domain.Movie;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieSpringRepositoryIT {

  @Autowired
  private MovieRepository movieRepository;

  /**
   * Example Task
   */
  @Test
  public void findAllShouldReturnAllActors() {

    List<Movie> movieList = movieRepository.findAll();
    assertThat(movieList.size(), is(equalTo(5)));

  }


  /**
   * Task 1
   */
  @Test
  public void getMoviesByGenreTest() {


  }


  /**
   * Task 2
   */
  @Test
  public void countPrizesByMovieTitleTest() {


  }

  /**
   * Task 3
   */
  @Test
  public void findMoviesByDirectorAddressShouldFindMovies() {


  }

  /**
   * Task 4
   */
  @Test
  public void findAllShouldReturnInRightSortOrder() {


  }


  /**
   * Task 1  JPQL
   */
  @Test
  public void findTopMoviesWithPrizesWithGivenText() {


  }



}
