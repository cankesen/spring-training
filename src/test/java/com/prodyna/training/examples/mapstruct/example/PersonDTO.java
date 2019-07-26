package com.prodyna.training.examples.mapstruct.example;

import lombok.Data;

@Data
public class PersonDTO {

    private String title;
    private String fullName;
    private Gender gender;
    private int age;
    private String birthday;


}
