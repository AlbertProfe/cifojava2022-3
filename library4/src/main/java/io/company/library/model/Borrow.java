package io.company.library.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name="Borrow")
@Table(name="BORROW_TABLE")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="BORROW_ID")
    private long borrowId;

    private LocalDate borrowedDate;
    private LocalDate backDueDate;
    private  LocalDate backDate;
    private boolean isBack;
    private int daysInBtw;
    private int fee;

    private List<User> users;
    private List<BookItem> bookItem;


}
