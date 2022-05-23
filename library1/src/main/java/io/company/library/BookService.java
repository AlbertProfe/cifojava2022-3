package io.company.library;


import java.util.List;
import java.util.Optional;

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

        Book bookCreated = bookRepository.save(book);

        return bookCreated;
    }

    public Optional<Book> findBookById(Long id){

        return bookRepository.findById(id);
    }

    public Optional<Book> findBookByTitle(String title){
        bookRepository.findBookByTitle(title);

        return null;
    }

    public  Book deleteBookById(Long id){
        //Find out IF this id-book IS in our DB


        //
        return null;
    }

    public  Book deleteBookByTitle(String title){
        //Find out IF this id-book IS in our DB

        Optional<Book> deletedBook = bookRepository.deleteBookByTitle(title);
        //
        return null;
    }




}