package net.company.ms.petstoreservice.codeimpl.api;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.company.ms.petstoreservice.codegen.api.PetApiDelegate;
import net.company.ms.petstoreservice.codegen.model.Pet;
import net.company.ms.petstoreservice.codeimpl.dto.PetDto;
import net.company.ms.petstoreservice.codeimpl.repository.PetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class PetApiDelegateImpl implements PetApiDelegate {

  PetRepository petRepository;

  @Override
  public ResponseEntity<Pet> addPet(Pet pet) {
    // NB: Transformers should be implemented in external common prj. Take a look to:
    // https://github.com/cmauri75/saga
    PetDto saved = petRepository.save(PetDto.builder().id(pet.getId()).name(pet.getName()).build());
    Pet res = new Pet().id(saved.getId()).name(saved.getName());

    log.debug("Saved pet: {}", res);
    return new ResponseEntity<>(res, HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<Pet> getPetById(Long petId) {
    Optional<PetDto> got = petRepository.findById(petId);
    log.debug("Got pet: {}", got);

    if (got.isEmpty())
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    return new ResponseEntity<>(new Pet().id(got.get().getId()).name(got.get().getName()),
        HttpStatus.OK);
  }

}
