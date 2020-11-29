package me.kodilla.library.repository;

import me.kodilla.library.domain.Borrower;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BorrowerRepository extends CrudRepository<Borrower,Long> {
    List<Borrower> findAll();
    Optional<Borrower> findById(Long id);
}
