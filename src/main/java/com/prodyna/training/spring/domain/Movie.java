package com.prodyna.training.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Entity
@Table(name = "movie")
@JsonInclude(Include.NON_NULL)
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
  @OneToMany(mappedBy = "movie", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  private Set<Act> acts;

  @JsonIgnoreProperties("movies")
  @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, optional = false)
  private Director director;

  @JsonIgnoreProperties("movie")
  @OneToMany(mappedBy = "movie", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  private Set<Prize> prizes;

  @JsonIgnoreProperties("movies")
  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(
      name = "produces",
      joinColumns = @JoinColumn(name = "production_company_id"),
      inverseJoinColumns = @JoinColumn(name = "movie_id")
  )
  private Set<ProductionCompany> productionCompanies;

  public void setActs(Set<Act> acts) {
    this.acts = acts;
    acts.forEach(act -> act.setMovie(this));
  }

  public void setPrizes(Set<Prize> prizes) {
    this.prizes = prizes;
    prizes.forEach(prize -> prize.setMovie(this));
  }

}
