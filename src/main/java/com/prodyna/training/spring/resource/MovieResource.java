package com.prodyna.training.spring.resource;

import com.prodyna.training.spring.dao.custom.AppRepository;
import com.prodyna.training.spring.domain.Movie;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MovieResource {

  //Autowire custom repo

  //implement
  public List<Movie> getMovies() {

    return null;

  }

  //implement
  public ResponseEntity<Movie> getMovie( Long id) {

    return null;

  }

  //implement
  public ResponseEntity<Movie> createMovie( Movie movie){

    return null;

  }

}
