package com.prodyna.training.examples.mapstruct.example;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {
    DateMapper.class,
    PersonMapper.class,
    PersonMapperImpl.class
})
public class MapStructTest {

  @Autowired
  PersonMapper personMapper;

  @Test
  public void convertToDtoAndBack() {
    PersonEntity personEntity = PersonEntity.builder().title("Mr").name("Leonardo di Caprio")
        .gender(
            Gender.MALE).age(45).birthday(new Date(88, 1, 1)).build();

    PersonDTO personDTO = personMapper.personEntityToPersonDto(personEntity);
    PersonEntity personEntityConverted = personMapper.personDtoToPersonEntity(personDTO);

    assertThat(personEntity, is(equalTo(personEntityConverted)));

  }

  @Test
  public void convertToDto() {

    PersonEntity personEntity = PersonEntity.builder().title("Mr").name("Leonardo di Caprio")
        .gender(
            Gender.MALE).age(45).birthday(new Date(88, 1, 1)).build();
    PersonDTO personDTO = personMapper.personEntityToPersonDto(personEntity);

    assertThat(personDTO, is(notNullValue()));
    assertThat(personDTO.getTitle(), is("Mr"));
    assertThat(personDTO.getFullName(), is("Leonardo di Caprio"));
    assertThat(personDTO.getGender(), is(Gender.MALE));
    assertThat(personDTO.getAge(), is(45));
    assertThat(personDTO.getBirthday(), is("1988-02-01"));

    //reverse

    PersonEntity personEntityFromDto = personMapper.personDtoToPersonEntity(personDTO);
    assertThat(personEntityFromDto, is(notNullValue()));
    assertThat(personEntityFromDto.getTitle(), is("Mr"));
    assertThat(personEntityFromDto.getName(), is("Leonardo di Caprio"));
    assertThat(personEntityFromDto.getGender(), is(Gender.MALE));
    assertThat(personEntityFromDto.getAge(), is(45));

    //Composition

    AccountEntity accountEntity = AccountEntity.builder().balance(100).build();

    PersonalAccountDTO personalAccountDTO = personMapper
        .personAndAccountEntityToPersonalAccountDto(personEntity, accountEntity);

    assertThat(personalAccountDTO, is(notNullValue()));
    assertThat(personalAccountDTO.getCustomerName(), is("Leonardo di Caprio"));
    assertThat(personalAccountDTO.getBalanceSum(), is(100));


  }
}
