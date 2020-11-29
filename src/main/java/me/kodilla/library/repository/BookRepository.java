package me.kodilla.library.repository;

import me.kodilla.library.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book,Long> {
    List<Book> findAll();
    Optional<Book> findById(Long id);
}
