package com.prodyna.training.examples.jackson;

import java.io.IOException;
import java.io.InputStream;
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
  public void createPersonAndMarshalToFileTest() {

    try {

    } catch (Exception e) {

    }

  }

  /**
   * Test 2
   */
  @Test
  public void unMarshalToPersonFromStringTest() {
    try {

    } catch (Exception e) {

    }
  }


  /**
   * Test 3
   */
  @Test
  public void readFileAsJsonNodeTest() {
    try {

    } catch (Exception e) {

    }
  }

  /**
   * Test 4
   */
  @Test
  public void readStringAsPersonListTest() {

    String jsonArray =
        "[{ \"title\" : \"mr\", \"fullName\" : \"Neo\" }, { \"title\" : \"mrs\", \"fullName\" : \"Alice\" }]";

    try {

    } catch (Exception e) {

    }
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
    }
  }



}
