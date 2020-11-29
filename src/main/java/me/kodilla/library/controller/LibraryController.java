package me.kodilla.library.controller;

import lombok.RequiredArgsConstructor;
import me.kodilla.library.controller.exceptions.BookNotFoundException;
import me.kodilla.library.controller.exceptions.BorrowerNotFoundException;
import me.kodilla.library.controller.exceptions.RentNotFoundException;
import me.kodilla.library.controller.exceptions.TitleNotFoundException;
import me.kodilla.library.domain.Book;
import me.kodilla.library.domain.Borrower;
import me.kodilla.library.domain.Rent;
import me.kodilla.library.domain.Title;
import me.kodilla.library.domain.dto.BookDto;
import me.kodilla.library.domain.dto.BorrowerDto;
import me.kodilla.library.domain.dto.RentDto;
import me.kodilla.library.domain.dto.TitleDto;
import me.kodilla.library.mapper.BookMapper;
import me.kodilla.library.mapper.BorrowerMapper;
import me.kodilla.library.mapper.RentMapper;
import me.kodilla.library.mapper.TitleMapper;
import me.kodilla.library.service.DbService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lib")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class LibraryController {

    private final DbService service;
    private final TitleMapper titleMapper;
    private final BookMapper bookMapper;
    private final BorrowerMapper borrowerMapper;
    private final RentMapper rentMapper;

    //Title

    @GetMapping(value = "getTitle")
    public TitleDto getTitle(@RequestParam Long id) throws TitleNotFoundException {
        return titleMapper.mapToTitleDto(
                service.getTitle(id).orElseThrow(TitleNotFoundException::new)
        );
    }

    @GetMapping(value = "getTitles")
    public List<TitleDto> getTitles() {
        return titleMapper.mapToTitleDtoList(service.getAllTitles());
    }

    @PostMapping(value = "createTitle")
    public void createTitle(@RequestBody TitleDto titleDto) {
        Title title = titleMapper.mapToTitle(titleDto);
        service.saveTitle(title);
    }

    @PutMapping(value = "updateTitle")
    public TitleDto updateTitle(@RequestBody TitleDto titleDto) {
        Title title = titleMapper.mapToTitle(titleDto);
        Title savedTitle = service.saveTitle(title);
        return titleMapper.mapToTitleDto(savedTitle);
    }

    @DeleteMapping(value = "deleteTitle")
    public void deleteTitle(@RequestParam Long id) throws TitleNotFoundException{
        Title title = service.getTitle(id).orElseThrow(TitleNotFoundException::new);
        service.deleteTitle(title);
    }

    //Book

    @GetMapping(value = "getBook")
    public BookDto getBook(@RequestParam Long id) throws BookNotFoundException {
        return bookMapper.mapToBookDto(
                service.getBook(id).orElseThrow(BookNotFoundException::new)
        );
    }

    @GetMapping(value = "getBooks")
    public List<BookDto> getBooks() {
        return bookMapper.mapToBookDtoList(service.getAllBooks());
    }

    @GetMapping(value = "getNumberOfBooksAvailable")
    public long getNumberOfBooksAvailableWithTitle(@RequestBody TitleDto titleDto) {
        Title title = titleMapper.mapToTitle(titleDto);
        long allBooks = service.getAllBooks().stream()
                .map(e -> e.getTitle().equals(title))
                .count();
        long rentedBooks = service.getAllRentals().stream()
                .map(e -> e.getBook().getTitle().equals(title))
                .count();
        return allBooks-rentedBooks;
    }

    @PostMapping(value = "createBook")
    public void createBook(@RequestBody BookDto bookDto) throws TitleNotFoundException {
        Title title = service.getTitle(bookDto.getTitle_id()).orElseThrow(TitleNotFoundException::new);
        Book book = bookMapper.mapToBook(bookDto,title);
        service.saveBook(book);
    }

    @PutMapping(value = "updateBook")
    public BookDto updateBook(@RequestBody BookDto bookDto) throws TitleNotFoundException {
        Title title = service.getTitle(bookDto.getTitle_id()).orElseThrow(TitleNotFoundException::new);
        Book book = bookMapper.mapToBook(bookDto,title);
        Book savedBook = service.saveBook(book);
        return bookMapper.mapToBookDto(savedBook);
    }

    @PutMapping(value = "updateBookState")
    public BookDto updateBookState(@RequestParam Long id,@RequestParam String state) throws BookNotFoundException {
        Book book = service.getBook(id).orElseThrow(BookNotFoundException::new);
        book.setBookState(state);
        Book savedBook = service.saveBook(book);
        return bookMapper.mapToBookDto(savedBook);
    }

    @DeleteMapping(value = "deleteBook")
    public void deleteBook(@RequestParam Long id) throws BookNotFoundException {
        Book book = service.getBook(id).orElseThrow(BookNotFoundException::new);
        service.deleteBook(book);
    }

    //Borrower

    @GetMapping(value = "getBorrower")
    public BorrowerDto getBorrower(@RequestParam Long id) throws BorrowerNotFoundException {
        return borrowerMapper.mapToBorrowerDto(
                service.getBorrower(id).orElseThrow(BorrowerNotFoundException::new)
        );
    }

    @GetMapping(value = "getBorrowers")
    public List<BorrowerDto> getBorrowers() {
        return borrowerMapper.mapToBorrowerDtoList(service.getAllBorrowers());
    }

    @PostMapping(value = "createBorrower")
    public void createBorrower(@RequestBody BorrowerDto borrowerDto) {
        Borrower borrower = borrowerMapper.mapToBorrower(borrowerDto);
        service.saveBorrower(borrower);
    }

    @PutMapping(value = "updateBorrower")
    public BorrowerDto updateBorrower(@RequestBody BorrowerDto borrowerDto) {
        Borrower borrower = borrowerMapper.mapToBorrower(borrowerDto);
        Borrower savedBorrower = service.saveBorrower(borrower);
        return borrowerMapper.mapToBorrowerDto(savedBorrower);
    }

    @DeleteMapping(value = "deleteBorrower")
    public void deleteBorrower(@RequestParam Long id) throws BorrowerNotFoundException {
        Borrower borrower = service.getBorrower(id).orElseThrow(BorrowerNotFoundException::new);
        service.deleteBorrower(borrower);
    }

    //Rent

    @GetMapping(value = "getRent")
    public RentDto getRent(@RequestParam Long id) throws RentNotFoundException {
        return rentMapper.mapToRentDto(
                service.getRent(id).orElseThrow(RentNotFoundException::new)
        );
    }

    @GetMapping(value = "getRents")
    public List<RentDto> getRents() {
        return rentMapper.mapToRentDtoList(service.getAllRentals());
    }

    @PostMapping(value = "createRent")
    public void createRent(@RequestBody RentDto rentDto) throws BookNotFoundException, BorrowerNotFoundException {
        Book book = service.getBook(rentDto.getBook_id()).orElseThrow(BookNotFoundException::new);
        Borrower borrower = service.getBorrower(rentDto.getBorrower_id()).orElseThrow(BorrowerNotFoundException::new);
        Rent rent = rentMapper.mapToRent(rentDto,book,borrower);
        service.saveRent(rent);
    }

    @PutMapping(value = "updateRent")
    public RentDto updateRent(@RequestBody RentDto rentDto) throws BookNotFoundException, BorrowerNotFoundException {
        Book book = service.getBook(rentDto.getBook_id()).orElseThrow(BookNotFoundException::new);
        Borrower borrower = service.getBorrower(rentDto.getBorrower_id()).orElseThrow(BorrowerNotFoundException::new);
        Rent rent = rentMapper.mapToRent(rentDto,book,borrower);
        Rent savedRent = service.saveRent(rent);
        return rentMapper.mapToRentDto(savedRent);
    }

    @DeleteMapping(value = "deleteRent")
    public void deleteRent(@RequestParam Long id) throws RentNotFoundException {
        Rent rent = service.getRent(id).orElseThrow(RentNotFoundException::new);
        service.deleteRent(rent);
    }

}
