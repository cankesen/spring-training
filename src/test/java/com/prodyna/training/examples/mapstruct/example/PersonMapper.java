package com.prodyna.training.examples.mapstruct.example;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = DateMapper.class, componentModel = "spring")
public interface PersonMapper {

    //optional : if no component model spring active use the static instance
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(source = "name", target = "fullName")
    @Mapping(source = "birthday", target = "birthday")
    PersonDTO personEntityToPersonDto(PersonEntity personEntity);

    @InheritInverseConfiguration
    PersonEntity personDtoToPersonEntity(PersonDTO personDto);

    @Mapping(source = "personEntity.name", target = "customerName")
    @Mapping(source = "accountEntity.balance", target = "balanceSum")
    PersonalAccountDTO personAndAccountEntityToPersonalAccountDto
        (PersonEntity personEntity, AccountEntity accountEntity);


}
