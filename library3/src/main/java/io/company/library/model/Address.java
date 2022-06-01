package io.company.library.model;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "address")
@Table(name="ADDRESS_TABLE")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ADDRESS_ID")
    private Long addressId;
    private String street;
    private int number;
    private String postalCode;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "LIBRARY_FK")
    private Library library;

    //constructor without ID
    public Address (String street, int number, String postalCode){
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
    }
}
