package me.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="rentals")
public class Rent {
    @Id
    @GeneratedValue
    @Column(name = "rent_id")
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book book;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name="borrower_id")
    private Borrower borrower;

    @Column(name="borrow_date")
    private LocalDate borrowDate;

    @Column(name="return_date")
    private LocalDate returnDate;
}
