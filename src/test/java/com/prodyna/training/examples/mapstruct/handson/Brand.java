package com.prodyna.training.examples.mapstruct.handson;

import java.io.Serializable;
import java.util.List;
import lombok.Builder;
import lombok.Data;

public class Brand implements Serializable {

  private int id;

  private String name;

  private List<Product> products;


}
