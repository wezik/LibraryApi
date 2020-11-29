package me.kodilla.library.repository;

import me.kodilla.library.domain.Rent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RentRepository extends CrudRepository<Rent,Long> {
    List<Rent> findAll();
    Optional<Rent> findById(Long id);
}
