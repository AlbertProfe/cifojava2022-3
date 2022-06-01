package io.company.library.model;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "library")
@Table(name="LIBRARY_TABLE")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="LIBRARY_ID")
    private Long libraryId;
    private String name;
    private int qtyItems;

    @OneToOne(mappedBy = "library", cascade = CascadeType.ALL)
    private Address address;

    @ManyToMany(mappedBy = "libraries", cascade = CascadeType.ALL,
                fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList<>();

    //constructor without ID
    public Library (String name, int qtyItems){
        this.name = name;
        this.qtyItems = qtyItems;
    }

}
