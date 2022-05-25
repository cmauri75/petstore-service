package net.company.ms.petstoreservice.codeimpl;

import net.company.ms.petstoreservice.codeimpl.dto.PetDto;
import net.company.ms.petstoreservice.codeimpl.repository.PetRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PetStoreRepositoryTest {

  @Autowired
  private PetRepository petRepository;

  @Test
  @Order(0)
  void should_find_onlyOne() {
    Iterable<PetDto> l = petRepository.findAll();
    assertThat(l).hasSize(1);
    assertThat(l.iterator().next().getName()).isEqualTo("Sato");
  }
}
