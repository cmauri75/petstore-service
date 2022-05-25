package net.company.ms.petstoreservice.codeimpl;

import net.company.ms.petstoreservice.codeimpl.api.PetApiDelegateImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PetStoreServiceTest {

  @Autowired
  private PetApiDelegateImpl petApiDelegateImpl;

  @Test
  void should_retreive() {
    var res = petApiDelegateImpl.getPetById(-1L);
    assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(Objects.requireNonNull(res.getBody()).getName()).isEqualTo("Sato");
  }
}
