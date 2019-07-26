package com.prodyna.training.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Entity
@Table(name = "production_company")
public class ProductionCompany implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NaturalId
    private String name;

    @JsonIgnoreProperties("productionCompanies")
    //Implement
    private Set<Movie> movies;

}
