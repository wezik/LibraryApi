package me.kodilla.library.repository;

import me.kodilla.library.domain.Title;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TitleRepository extends CrudRepository<Title,Long> {
    List<Title> findAll();
    Optional<Title> findById(Long id);
}
