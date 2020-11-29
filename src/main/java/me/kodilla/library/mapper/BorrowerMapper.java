package me.kodilla.library.mapper;

import me.kodilla.library.domain.Borrower;
import me.kodilla.library.domain.dto.BorrowerDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowerMapper {
    public Borrower mapToBorrower(final BorrowerDto o) {
        return new Borrower(
                o.getId(),
                o.getName(),
                o.getLastName(),
                o.getCreated()
        );
    }

    public BorrowerDto mapToBorrowerDto(final Borrower o) {
        return new BorrowerDto(
                o.getId(),
                o.getName(),
                o.getLastName(),
                o.getCreated()
        );
    }

    public List<BorrowerDto> mapToBorrowerDtoList(final List<Borrower> borrowers) {
        return borrowers.stream()
                .map(this::mapToBorrowerDto)
                .collect(Collectors.toList());
    }
}
