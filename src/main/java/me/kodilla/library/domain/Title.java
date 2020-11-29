package me.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="titles")
public class Title {
    @Id
    @GeneratedValue
    @Column(name="title_id")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="author")
    private String author;

    @Column(name="release_date")
    private LocalDate releaseDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title1 = (Title) o;
        return Objects.equals(id, title1.id) &&
                Objects.equals(title, title1.title) &&
                Objects.equals(author, title1.author) &&
                Objects.equals(releaseDate, title1.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, releaseDate);
    }
}
