package me.kodilla.library.mapper;

import me.kodilla.library.domain.Borrower;
import me.kodilla.library.domain.dto.BorrowerDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowerMapper {
    public Borrower mapToBorrower(final BorrowerDto borrowerDto) {
        return new Borrower(
                borrowerDto.getId(),
                borrowerDto.getName(),
                borrowerDto.getLastName(),
                borrowerDto.getCreated()
        );
    }

    public BorrowerDto mapToBorrowerDto(final Borrower borrower) {
        return new BorrowerDto(
                borrower.getId(),
                borrower.getName(),
                borrower.getLastName(),
                borrower.getCreated()
        );
    }

    public List<BorrowerDto> mapToBorrowerDtoList(final List<Borrower> borrowers) {
        return borrowers.stream()
                .map(this::mapToBorrowerDto)
                .collect(Collectors.toList());
    }
}
