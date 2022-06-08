package io.company.library.model;

import lombok.*;
import javax.persistence.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@ToString
@Entity(name="BookItem")
@Table(name="BOOK_ITEM_TABLE")
public class BookItem extends Book{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="BOOK_ITEM_ID")
    private long bookItemId;

    private Enum status;
}
