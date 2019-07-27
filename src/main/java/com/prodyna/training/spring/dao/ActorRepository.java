package com.prodyna.training.spring.dao;

import com.prodyna.training.spring.domain.Actor;
import com.prodyna.training.spring.domain.PersonExcerpt;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "actors", itemResourceRel = "actor",
    path = "actors", excerptProjection = PersonExcerpt.class)
public interface ActorRepository extends JpaRepository<Actor, Long> {


  /**
   * Task 2 Spring Data Rest
   * Not exposed in Endpoint
   * profile/actors/
   * @param s
   * @param <S>
   * @return
   */
  @Override
  @RestResource(exported = false)
  <S extends Actor> S save(S s);


  /**
   * Task 1 Query
   * http://localhost:8080/api/actors/search/query?name=Keanu+Reeves
   *
   *
   * Task 3 Spring Data Rest
   * use actors/query instead of actors/findByName
   *
   * @param name
   * @return
   */
  @RestResource(path = "query")
  List<Actor> findByName(@Param("name") String name);


  /**
   * Task 2
   * http://localhost:8080/api/actors/search/findByCar_Brand?brand=Audi
   * @param brand
   * @return
   */
  List<Actor> findByCar_Brand(@Param("brand") String brand);

  /**
   * Task 3
   * http://localhost:8080/api/actors/search/findByAddress_PostalCode?postalCode=56767
   * @param postalCode
   * @return
   */
  List<Actor> findByAddress_PostalCode(@Param("postalCode") int postalCode);

  /**
   * Task 4
   * http://localhost:8080/api/actors/search/findByAddress_StreetIgnoreCaseContaining?street=street&sort=name,asc
   */
  List<Actor> findByAddress_StreetIgnoreCaseContaining(@Param("street") String street, Sort sort);


}
