package com.prodyna.training.spring.resource;

import com.prodyna.training.spring.aspect.Profile;
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
@RequestMapping("/api/v1")
public class MovieResource {

  private AppRepository appRepository;

  public MovieResource(@Autowired AppRepository appRepository) {
    this.appRepository = appRepository;
  }

  @Profile
  @GetMapping(value = "/movies", produces = {"application/json"})
  public List<Movie> getMovies() {

    return appRepository.getMovies();

  }

  @GetMapping(value = "/movies/{id}", produces = {"application/json"})
  public ResponseEntity<Movie> getMovie(@PathVariable Long id) {

    Movie movie = appRepository.findMovie(id);
    return ResponseEntity.ok(movie);

  }

  @PostMapping(value = "/movies", consumes = {"application/json"}, produces = {"application/json"})
  public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){

    Movie createdMovie = appRepository.createMovie(movie);
    return ResponseEntity.ok(createdMovie);

  }

}
