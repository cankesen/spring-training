package com.prodyna.training.spring.integration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import com.prodyna.training.spring.dao.ActorRepository;
import com.prodyna.training.spring.domain.Actor;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ActorSpringRepositoryIT {

  @Autowired
  private ActorRepository actorRepository;

  /**
   * Example
   */
  @Test
  public void findAllShouldReturnAllActors() {

    List<Actor> actorSet = actorRepository.findAll();
    assertThat(actorSet.size(), is(equalTo(7)));

  }

  /**
   * Task 1
   */
  @Test
  public void findByNameShouldReturnASingleActor() {


  }

  /**
   * Task 2
   */
  @Test
  public void findByCarBrandShouldReturnOwningActors() {


  }

  /**
   * Task 3
   */
  @Test
  public void findByAddressPostalCodeShouldReturnRelatedActors() {


  }

  /**
   * Task 4
   */
  @Test
  public void findByAddressStreetNameContains_ReturnsAllContaining_Sorted() {



  }



}
