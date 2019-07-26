package com.prodyna.training.examples.mapstruct.handson;


import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductDto implements Serializable {

  private int id;

  private String description;

  private boolean onSale;

}
