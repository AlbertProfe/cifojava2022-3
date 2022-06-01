package io.company.library.model;

//https://projectlombok.org/features/all
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@ToString
@Entity(name="Book")
@Table(name="BOOK_TABLE")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="BOOK_ID")
    private long bookId;
    @Column(name="BOOK_TITLE")
    private String title;
    private int pages;
    @Column(name="PUBLISHED_YEAR")
    private int publishedYear;
    @Column(name="ISBN")
    private String isbn;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(	name = "LIBRARY_BOOK_JOIN_TABLE",
                joinColumns = { @JoinColumn(name = "BOOK_FK") },
                inverseJoinColumns = { @JoinColumn(name = "LIBRARY_FK") })
    private List<Library> libraries = new ArrayList<>();

    //constructor without ID
    public Book(String title, int pages, int publishedYear, String isbn) {
        this.title = title;
        this.pages = pages;
        this.publishedYear = publishedYear;
        this.isbn = isbn;
    }

}