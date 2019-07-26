package com.prodyna.training.examples.mapstruct.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
public class AccountEntity {

    private int balance;

}
