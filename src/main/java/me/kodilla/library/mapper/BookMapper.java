package me.kodilla.library.mapper;

import lombok.RequiredArgsConstructor;
import me.kodilla.library.controller.exceptions.TitleNotFoundException;
import me.kodilla.library.domain.Book;
import me.kodilla.library.domain.dto.BookDto;
import me.kodilla.library.repository.TitleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class BookMapper {

    TitleRepository titleRepository;

    public Book mapToBook(final BookDto o) throws TitleNotFoundException {
        return new Book(
                o.getId(),
                titleRepository.findById(o.getTitle_id()).orElseThrow(TitleNotFoundException::new),
                o.getBookState()
        );
    }

    public BookDto mapToBookDto(final Book o) {
        return new BookDto(
                o.getId(),
                o.getTitle().getId(),
                o.getBookState()
        );
    }

    public List<BookDto> mapToBookDtoList(final List<Book> books) {
        return books.stream()
                .map(this::mapToBookDto)
                .collect(Collectors.toList());
    }
}
