package com.prodyna.training.spring.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@ToString
@Builder
public class Car implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NaturalId
    private String vin;

    private String brand;

    private String model;

    //Implement
    @JsonBackReference
    @ToString.Exclude
    private Person person;

}
