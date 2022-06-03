package io.company.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@MappedSuperclass
public abstract class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    private  long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "PAGES")
    private int pages;
    @Column(name="PUBLISHED_YEAR")
    private int publishedYear;
    @Column(name="ISBN")
    private String isbn;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "AUTHOR_BOOK_JOIN_TABLE",
            joinColumns = { @JoinColumn(name = "WORK_FK" )},
            inverseJoinColumns = { @JoinColumn(name = "AUTHOR_FK" )})
    private Set<Author> authors = new HashSet<Author>();




}
