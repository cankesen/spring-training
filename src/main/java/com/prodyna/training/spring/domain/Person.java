package com.prodyna.training.spring.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@Table( name="person", uniqueConstraints = {
        @UniqueConstraint(name = "uniqueCar", columnNames = {"car_id"})
})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Person_type")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public abstract class Person implements Serializable {

    @Id
    @SequenceGenerator(name = "PERSON_ID_GENERATOR", initialValue = 20, allocationSize = 10, sequenceName = "PERSON_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
            "PERSON_ID_GENERATOR")
    private Long id;

    @Column
    private String name;

    @JsonManagedReference
    //Implement
    private Car car;

    @JsonManagedReference
    //Implement
    private Biography biography;

    @Embedded
    Address address;

    public void setCar(Car car){
        if(car != null){
            this.car = car;
            car.setPerson(this);
        }
    }

  public void setBiography(Biography biography){
    if(biography != null){
      this.biography = biography;
      biography.setPerson(this);
    }
  }

}
