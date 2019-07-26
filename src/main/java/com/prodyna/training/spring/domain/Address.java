package com.prodyna.training.spring.domain;

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AttributeOverrides({
    @AttributeOverride(name = "street", column = @Column(name = "address_street")),
    @AttributeOverride(name = "postalCode", column = @Column(name = "address_postal_code"))
})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {

  @Column(name = "address_street")
  private String street;

  private int postalCode;

}
