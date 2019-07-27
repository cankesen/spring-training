package com.prodyna.training.spring.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Builder
public class Car implements Serializable {

  @Id
  @SequenceGenerator(name = "CAR_ID_GENERATOR", initialValue = 20, allocationSize = 10, sequenceName = "PERSON_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAR_ID_GENERATOR")
  private Long id;

  @NaturalId
  private String vin;

  private String brand;

  private String model;

  @OneToOne(mappedBy = "car")
  @JsonBackReference
  @ToString.Exclude
  private Person person;

}
