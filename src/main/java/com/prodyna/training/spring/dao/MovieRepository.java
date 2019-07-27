package com.prodyna.training.spring.dao;

import com.prodyna.training.spring.domain.Genre;
import com.prodyna.training.spring.domain.Movie;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

  //Method Queries

  /**
   * Task 1
   * http://localhost:8080/api/movies/search/queryByGenre?genre=DRAMA
   * @param genre
   * @return
   */
  Set<Movie> queryByGenre(@Param("genre") Genre genre);

  /**
   * Task 2
   * http://localhost:8080/api/movies/search/countAllByPrizes_Movie_Title?name=Matrix
   * @param name
   * @return
   */
  Long countAllByPrizes_Movie_Title(@Param("name") String name);


  /**
   * Task 3
   * http://localhost:8080/api/movies/search/findAllByDirector_AddressPostalCodeIn?postCodes=56767,11111,55767
   * @param postCodes
   * @return
   */
  List<Movie> findAllByDirector_AddressPostalCodeIn(@Param("postCodes") Set<Integer> postCodes);

  //JPQL Queries

  /**
   * Task 1 JPQL Query
   *
   * http://localhost:8080/api/movies/search/getMoviesWithMostPrize?prizeText=%Oscar%
   * @param prizeText
   * @return
   */
  @Query("select m from Movie m join Prize p on p.movie.id = m.id "
      + " where p.name like :prizeText group by (m.id) "
      + " having count(m) > 0 order by count(m) desc ")
  List<Movie> getMoviesWithMostPrize(@Param("prizeText") String prizeText);






}
