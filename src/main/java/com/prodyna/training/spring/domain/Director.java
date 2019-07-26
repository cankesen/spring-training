package com.prodyna.training.spring.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorColumn(name = "Person_type")
@Getter
@Setter
public class Director extends Person {

  @JsonIgnoreProperties("director")
  @OneToMany(mappedBy = "director")
  private Set<Movie> movies;

  @Builder
  public Director(Long id, String name, Car car, Biography biography, Address address) {
    super(id, name, car, biography, address);
  }

  public Director() {
    super();
  }

}
