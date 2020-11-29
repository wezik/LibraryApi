package me.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="borrowers")
public class Borrower {
    @Id
    @GeneratedValue
    @Column(name = "borrower_id")
    private Long id;

    @Column(name="first_name")
    private String name;

    @Column(name="last_name")
    private String lastName;

    @Column(name="joined")
    private LocalDate created;
}
