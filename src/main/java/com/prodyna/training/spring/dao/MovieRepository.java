package com.prodyna.training.spring.dao;

import com.prodyna.training.spring.domain.Genre;
import com.prodyna.training.spring.domain.Movie;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

  //Method Queries

  /**
   * Task 1
   * @param genre
   * @return
   */


  /**
   * Task 2
   * @param name
   * @return
   */


  /**
   * Task 3
   * @param postCodes
   * @return
   */


  //JPQL Queries

  /**
   * Task 1
   *
   * @param prizeText
   * @return
   */



}
