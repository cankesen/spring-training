package com.prodyna.training.spring.dao.custom;

import com.prodyna.training.spring.domain.Movie;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

public class AppRepositoryImpl implements AppRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;


    @Transactional
    @Override
    public Movie findMovie(Long id) {

        return entityManager.find(Movie.class, id);

    }

}
