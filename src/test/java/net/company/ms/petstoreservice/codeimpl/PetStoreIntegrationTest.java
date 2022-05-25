package net.company.ms.petstoreservice.codeimpl;

import net.company.ms.petstoreservice.codegen.model.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.BasicJsonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PetStoreIntegrationTest {
  private static final String ROOT_PATH = "/api/v3";

  @Autowired
  private TestRestTemplate testRestTemplate;

  private final BasicJsonTester json = new BasicJsonTester(getClass());

  @Test
  void insertPet() {
    Pet newPet = new Pet().id(-2L).name("TestPet");

    ResponseEntity<String> responseEntity =
        this.testRestTemplate.postForEntity(ROOT_PATH + "/pet", newPet, String.class);

    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    assertThat(responseEntity.getBody()).isNotNull();

    JsonContent<?> jsonBody = json.from(responseEntity.getBody());
    assertThat(jsonBody).extractingJsonPathNumberValue("$.id").isEqualTo(-2);
    assertThat(jsonBody).extractingJsonPathStringValue("$.name").isEqualTo("TestPet");
  }

  @Test
  void testGetPet() {
    ResponseEntity<String> responseEntityNF =
        this.testRestTemplate.getForEntity(ROOT_PATH + "/pet/{petId}", String.class, "1");

    assertThat(responseEntityNF.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);


    ResponseEntity<String> responseEntitySato =
        this.testRestTemplate.getForEntity(ROOT_PATH + "/pet/{petId}", String.class, "-1");

    assertThat(responseEntitySato.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(responseEntitySato.getBody()).isNotNull();

    JsonContent<?> jsonBody = json.from(responseEntitySato.getBody());
    assertThat(jsonBody).extractingJsonPathNumberValue("$.id").isEqualTo(-1);
    assertThat(jsonBody).extractingJsonPathStringValue("$.name").isEqualTo("Sato");
  }


}
