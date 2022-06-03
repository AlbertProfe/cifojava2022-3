package io.company.model;

//https://projectlombok.org/features/all
import lombok.*;
import javax.persistence.*;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@ToString
@Entity(name="Book")
@Table(name="BOOK_TABLE")
public class Book extends Work {

    @Column(name="IS_SERIES")
    private boolean isSeries;
    @Column(name="IS_SCRIPT")
    private boolean isScript;


}

