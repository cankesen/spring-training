package com.prodyna.training.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@Entity
@Table(name = "movie")
public class Movie implements Serializable {

    @Id
    @SequenceGenerator(name = "MOVIE_ID_GENERATOR", initialValue = 20, allocationSize = 10, sequenceName = "MOVIE_SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator =
            "MOVIE_ID_GENERATOR")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @JsonIgnoreProperties("movie")
    //Implement
    private Set<Act> acts;

    @JsonIgnoreProperties("movies")
    //implement
    private Director director;


    @JsonIgnoreProperties("movie")
    //Implement
    private Set<Prize> prizes;

    public void setActs(Set<Act> acts) {
        this.acts = acts;
        acts.forEach(act -> act.setMovie(this));
    }

    public void setPrizes(Set<Prize> prizes) {
        this.prizes = prizes;
        prizes.forEach(prize -> prize.setMovie(this));
    }

    @JsonIgnoreProperties("movies")
    //implement
    private Set<ProductionCompany> productionCompanies;

}
