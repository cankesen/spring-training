package com.prodyna.training.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Entity
public class Prize implements Serializable {

    @Id
    @SequenceGenerator(name = "PRIZE_ID_GENERATOR", initialValue = 20, allocationSize = 10, sequenceName = "PRIZE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
            "PRIZE_ID_GENERATOR")
    private Long id;

    private String name;

    private Date date;

    //Implement
    @JsonIgnoreProperties("prizes")
    private Movie movie;

}
