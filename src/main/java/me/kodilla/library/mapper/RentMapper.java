package me.kodilla.library.mapper;

import me.kodilla.library.domain.Book;
import me.kodilla.library.domain.Borrower;
import me.kodilla.library.domain.Rent;
import me.kodilla.library.domain.dto.RentDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentMapper {
    public Rent mapToRent(final RentDto rentDto, final Book book, Borrower borrower) {
        return new Rent(
                rentDto.getId(),
                book,
                borrower,
                rentDto.getBorrowDate(),
                rentDto.getReturnDate()
        );
    }

    public RentDto mapToRentDto(final Rent rent) {
        return new RentDto(
                rent.getId(),
                rent.getBook().getId(),
                rent.getBorrower().getId(),
                rent.getBorrowDate(),
                rent.getReturnDate()
        );
    }

    public List<RentDto> mapToRentDtoList(final List<Rent> rents) {
        return rents.stream()
                .map(this::mapToRentDto)
                .collect(Collectors.toList());
    }
}
