package com.prodyna.training.spring.dao.custom;


import com.prodyna.training.spring.dao.MovieRepository;
import com.prodyna.training.spring.domain.Movie;
import org.springframework.data.repository.CrudRepository;

public interface AppRepository extends AppRepositoryCustom, MovieRepository {
}
