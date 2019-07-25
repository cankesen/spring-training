package com.prodyna.training.examples.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String title;
    private String fullName;
    private Gender gender;
    private int age;
    private String birthday;


}
