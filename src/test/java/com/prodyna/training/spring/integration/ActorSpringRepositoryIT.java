package com.prodyna.training.spring.integration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import com.prodyna.training.spring.dao.ActorRepository;
import com.prodyna.training.spring.domain.Actor;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
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

    List<Actor> actorList = actorRepository.findByName("Keanu Reeves");

    assertThat(actorList.size(), is(equalTo(1)));
    assertThat(actorList.get(0).getId(), is(equalTo(1L)));
    assertThat(actorList.get(0).getName(), is(equalTo("Keanu Reeves")));

  }

  /**
   * Task 2
   */
  @Test
  public void findByCarBrandShouldReturnOwningActors() {

    List<Actor> actorList = actorRepository.findByCar_Brand("Audi");

    assertThat(actorList.size(), is(equalTo(3)));

  }

  /**
   * Task 3
   */
  @Test
  public void findByAddressPostalCodeShouldReturnRelatedActors() {

    List<Actor> actorList = actorRepository.findByAddress_PostalCode(56767);

    assertThat(actorList.size(), is(equalTo(2)));

  }

  /**
   * Task 4
   */
  @Test
  public void findByAddressStreetNameContains_ReturnsAllContaining_Sorted() {

    List<Actor> actorList = actorRepository.findByAddress_StreetIgnoreCaseContaining("street",
        Sort.by("name").ascending());

    assertThat(actorList.size(), is(equalTo(7)));
    assertThat(actorList.get(0).getName(), is(containsString("Carie-Ann Moss")));

  }

}
