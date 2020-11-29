package me.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="books")
public class Book {

    @Id
    @GeneratedValue
    @Column(name= "book_id")
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "title_id")
    private Title title;

    @Column(name="state")
    private String bookState;

    public void setBookState(String s) {
        this.bookState = s;
    }
}
