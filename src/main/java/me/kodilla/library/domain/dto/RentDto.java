package me.kodilla.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.kodilla.library.domain.Book;
import me.kodilla.library.domain.Borrower;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class RentDto {
    private Long id;
    private Long book_id;
    private Long borrower_id;
    private LocalDate borrowDate;
    private LocalDate returnDate;
}
