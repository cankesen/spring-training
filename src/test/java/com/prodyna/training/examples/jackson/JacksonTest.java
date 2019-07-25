package com.prodyna.training.examples.jackson;

import static junit.framework.TestCase.fail;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

@Slf4j
public class JacksonTest {


  /**
   * Test 1
   */
  @Test
  public void createPersonAndMarshalToFileTest() throws Exception {

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    Person person = new Person("Mr", "Leonardo di Caprio",
        Gender.MALE, 45, "1988-02-01");
    objectMapper.writeValue(new File("target/person.json"), person);

  }

  /**
   * Test 2
   */
  @Test
  public void unMarshalToPersonFromStringTest() throws Exception {
    String personJson = "{\"title\":\"Mr\",\"fullName\":\"Leonardo di Caprio\",\"gender\":\"MALE\",\"age\":45,\"birthday\":\"1988-02-01\"}";

    ObjectMapper objectMapper = new ObjectMapper();
    Person person = objectMapper.readValue(personJson, Person.class);
    assertThat(person, is(notNullValue()));
    assertThat(person.getTitle(), is("Mr"));

  }

  /**
   * Test 3
   */
  @Test
  public void readFileAsJsonNodeTest() throws Exception {

    ObjectMapper objectMapper = new ObjectMapper();
    JsonNode personNode = objectMapper.readTree
        (loadFileToInputStream("jackson/person.json"));
    assertThat(personNode, is(notNullValue()));
    assertThat(personNode.get("title"), is(nullValue()));
    assertThat(personNode.get("fullName").textValue(), is("Leonardo di Caprio"));

  }

  /**
   * Test 4
   */
  @Test
  public void readStringAsPersonListTest() throws Exception {

    String jsonArray =
        "[{ \"title\" : \"mr\", \"fullName\" : \"Neo\" }, { \"title\" : \"mrs\", \"fullName\" : \"Alice\" }]";

    ObjectMapper objectMapper = new ObjectMapper();
    List<Person> listPerson = objectMapper
        .readValue(jsonArray, new TypeReference<List<Person>>() {
        });

    assertThat(listPerson.size(), is(2));
    assertThat(listPerson.get(0).getFullName(), is("Neo"));

  }

  private InputStream loadFileToInputStream(String path) throws IOException {
    return new ClassPathResource(path, this.getClass().getClassLoader()).getInputStream();
  }

  @Test
  public void validatePersonWithSchema() throws Exception {
    try {

      JSONObject jsonSchema = new JSONObject(
          new JSONTokener(loadFileToInputStream("jackson/person-scheme.json")));
      JSONObject jsonSubject = new JSONObject(
          new JSONTokener(loadFileToInputStream("jackson/person.json")));

      Schema schema = SchemaLoader.load(jsonSchema);
      schema.validate(jsonSubject);


    } catch (ValidationException e) {

      e.getCausingExceptions().stream()
          .forEach(ex -> log.info(ex.toString()));
      fail();

    }
  }


}
