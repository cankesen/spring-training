package com.prodyna.training.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity
@Table(name = "actor")
@DiscriminatorValue("Actor")
public class Actor extends Person{

    @JsonIgnoreProperties("actor")
    //Implement
    private Set<Act> acts;

    @Builder
    public Actor(Long id, String name, Car car, Biography biography, Address address) {
        super(id, name, car, biography, address);
    }

    public Actor() {
        super();
    }

    public void setActs(Set<Act> acts) {
        this.acts = acts;
        acts.forEach(act -> act.setActor(this));
    }

}
