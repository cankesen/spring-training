package com.prodyna.training.spring.dao;

import com.prodyna.training.spring.domain.Actor;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "actors", itemResourceRel = "actor", path = "actors")
public interface ActorRepository extends JpaRepository<Actor, Long> {


  /**
   * Task 1
   * @param name
   * @return
   */
  List<Actor> findByName(@Param("name") String name);


  /**
   * Task 2
   * @param brand
   * @return
   */
  List<Actor> findByCar_Brand(@Param("brand") String brand);

  /**
   * Task 3
   * @param postalCode
   * @return
   */
  List<Actor> findByAddress_PostalCode(@Param("postalCode") int postalCode);

  /**
   * Task 4
   */
  List<Actor> findByAddress_StreetIgnoreCaseContaining(@Param("street") String street, Sort sort);

}
