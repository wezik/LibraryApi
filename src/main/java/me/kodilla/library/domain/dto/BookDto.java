package me.kodilla.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookDto {
    private Long id;
    private Long title_id;
    private String bookState;
}
