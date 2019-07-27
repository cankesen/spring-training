package com.prodyna.training.spring.integration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import com.google.common.collect.Sets;
import com.prodyna.training.spring.dao.MovieRepository;
import com.prodyna.training.spring.domain.Genre;
import com.prodyna.training.spring.domain.Movie;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
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

    Set<Movie> movieList = movieRepository.queryByGenre(Genre.DRAMA);
    assertThat(movieList.size(), is(equalTo(1)));

  }

  /**
   * Task 2
   */
  @Test
  public void countPrizesByMovieTitleTest() {

    Long countMatrix = movieRepository.countAllByPrizes_Movie_Title("Matrix");
    assertThat(countMatrix, is(equalTo(3L)));

    Long countInception = movieRepository.countAllByPrizes_Movie_Title("Inception");
    assertThat(countInception, is(equalTo(1L)));

  }

  /**
   * Task 3
   */
  @Test
  public void findMoviesByDirectorAddressShouldFindMovies() {

    List<Movie> movieList = movieRepository
        .findAllByDirector_AddressPostalCodeIn(Sets.newHashSet(56767, 11111, 55767));

    assertThat(movieList.size(), is(equalTo(2)));


  }

  /**
   * Task 4
   */
  @Test
  public void findAllShouldReturnInRightSortOrder() {

    List<Movie> movieList = movieRepository
        .findAll(Sort.by("genre").ascending().and(Sort.by("title").descending()));

    assertThat(movieList.size(), is(equalTo(5)));

    assertThat(movieList.get(0).getTitle(), is(equalTo("John Wick")));
    assertThat(movieList.get(0).getGenre(), is(equalTo(Genre.ACTION)));

    assertThat(movieList.get(1).getTitle(), is(equalTo("Inception")));
    assertThat(movieList.get(1).getGenre(), is(equalTo(Genre.ACTION)));

    assertThat(movieList.get(2).getTitle(), is(equalTo("Titanic")));
    assertThat(movieList.get(2).getGenre(), is(equalTo(Genre.DRAMA)));

    assertThat(movieList.get(3).getTitle(), is(equalTo("Matrix")));
    assertThat(movieList.get(3).getGenre(), is(equalTo(Genre.SCI_FI)));

    assertThat(movieList.get(4).getTitle(), is(equalTo("Interstellar")));
    assertThat(movieList.get(4).getGenre(), is(equalTo(Genre.SCI_FI)));

  }

  /**
   * Task 1  JPQL
   */
  @Test
  public void findTopMoviesWithPrizesWithGivenText() {

    List<Movie> movieList = movieRepository.getMoviesWithMostPrize("%Oscar%");

    assertThat(movieList.size(), is(equalTo(2)));
    assertThat(movieList.get(0).getTitle(), is(equalTo("Matrix")));

    assertThat(movieList.get(1).getTitle(), is(equalTo("Titanic")));

  }

}
