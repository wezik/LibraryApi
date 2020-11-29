package me.kodilla.library.mapper;

import me.kodilla.library.domain.Book;
import me.kodilla.library.domain.Title;
import me.kodilla.library.domain.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookMapper {
    public Book mapToBook(final BookDto bookDto,final Title title) {
        return new Book(
                bookDto.getId(),
                title,
                bookDto.getBookState()
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
