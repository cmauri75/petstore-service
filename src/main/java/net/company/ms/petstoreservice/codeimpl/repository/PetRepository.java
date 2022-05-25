package net.company.ms.petstoreservice.codeimpl.repository;

import net.company.ms.petstoreservice.codeimpl.dto.PetDto;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PetRepository extends PagingAndSortingRepository<PetDto, Long> {

}
