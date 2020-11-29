package me.kodilla.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class BorrowerDto {
    private Long id;
    private String name;
    private String lastName;
    private LocalDate created;
}
