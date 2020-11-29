package me.kodilla.library.mapper;

import lombok.RequiredArgsConstructor;
import me.kodilla.library.controller.exceptions.BookNotFoundException;
import me.kodilla.library.controller.exceptions.BorrowerNotFoundException;
import me.kodilla.library.domain.Rent;
import me.kodilla.library.domain.dto.RentDto;
import me.kodilla.library.repository.BookRepository;
import me.kodilla.library.repository.BorrowerRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentMapper {

    BookRepository bookRepository;
    BorrowerRepository borrowerRepository;

    public Rent mapToRent(final RentDto o) throws BookNotFoundException, BorrowerNotFoundException {
        return new Rent(
                o.getId(),
                bookRepository.findById(o.getBook_id()).orElseThrow(BookNotFoundException::new),
                borrowerRepository.findById(o.getBorrower_id()).orElseThrow(BorrowerNotFoundException::new),
                o.getBorrowDate(),
                o.getReturnDate()
        );
    }

    public RentDto mapToRentDto(final Rent o) {
        return new RentDto(
                o.getId(),
                o.getBook().getId(),
                o.getBorrower().getId(),
                o.getBorrowDate(),
                o.getReturnDate()
        );
    }

    public List<RentDto> mapToRentDtoList(final List<Rent> rents) {
        return rents.stream()
                .map(this::mapToRentDto)
                .collect(Collectors.toList());
    }
}
