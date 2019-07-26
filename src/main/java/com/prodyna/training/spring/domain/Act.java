package com.prodyna.training.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity(name = "Act")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Act implements Serializable {

  @Id
  //Implement
  @JsonIgnoreProperties("acts")
  private Actor actor;

  @Id
  //Implement
  @JsonIgnoreProperties("acts")
  private Movie movie;

  private String role;

}
