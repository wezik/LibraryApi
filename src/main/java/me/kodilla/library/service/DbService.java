package me.kodilla.library.service;

import lombok.RequiredArgsConstructor;
import me.kodilla.library.domain.Book;
import me.kodilla.library.domain.Borrower;
import me.kodilla.library.domain.Rent;
import me.kodilla.library.domain.Title;
import me.kodilla.library.repository.BookRepository;
import me.kodilla.library.repository.BorrowerRepository;
import me.kodilla.library.repository.RentRepository;
import me.kodilla.library.repository.TitleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbService {

    private final TitleRepository titleRepository;
    private final BookRepository bookRepository;
    private final BorrowerRepository borrowerRepository;
    private final RentRepository rentRepository;

    public List<Title> getAllTitles() {
        return titleRepository.findAll();
    }

    public Optional<Title> getTitle(Long id) {
        return titleRepository.findById(id);
    }

    public Title saveTitle(final Title title) {
        return titleRepository.save(title);
    }

    public void deleteTitle(final Title title) {
        titleRepository.delete(title);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBook(Long id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(final Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(final Book book) {
        bookRepository.delete(book);
    }

    public List<Borrower> getAllBorrowers() {
        return borrowerRepository.findAll();
    }

    public Optional<Borrower> getBorrower(Long id) {
        return borrowerRepository.findById(id);
    }

    public Borrower saveBorrower(final Borrower borrower) {
        return borrowerRepository.save(borrower);
    }

    public void deleteBorrower(final Borrower borrower) {
        borrowerRepository.delete(borrower);
    }

    public List<Rent> getAllRentals() {
        return rentRepository.findAll();
    }

    public Optional<Rent> getRent(Long id) {
        return rentRepository.findById(id);
    }

    public Rent saveRent(final Rent rent) {
        return rentRepository.save(rent);
    }

    public void deleteRent(final Rent rent) {
        rentRepository.delete(rent);
    }
}
