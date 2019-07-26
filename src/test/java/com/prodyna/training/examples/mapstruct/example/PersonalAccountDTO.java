package com.prodyna.training.examples.mapstruct.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class PersonalAccountDTO {

    private int balanceSum;
    private String customerName;

}
