package com.prodyna.training.examples.di;

import org.springframework.beans.factory.annotation.Autowired;

public class Dao {

  private String name;

  public Dao(@Autowired String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Dao{" +
        "name='" + name + '\'' +
        '}';
  }
}
