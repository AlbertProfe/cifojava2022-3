package io.company.library;

//https://projectlombok.org/features/all
import lombok.*;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Book {

    private String title;
    private String author;
    private int pages;
    private int year;
    private String ISBN;

}