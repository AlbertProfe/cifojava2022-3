package io.company.library;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Iterable<Book> getAllBooks() {

       Iterable<Book> books = bookRepository.findAll();

        return books;
    }

    public Book createBook (Book book){

        bookRepository.save(book);

        return null;
    }


}