package com.prodyna.training.examples.mapstruct.example;


import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonEntity {

    private String title;
    private String name;
    private Gender gender;
    private int age;
    private Date birthday;

}
