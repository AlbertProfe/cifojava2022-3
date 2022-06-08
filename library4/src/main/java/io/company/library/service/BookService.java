package io.company.library.service;

import java.util.Optional;

import io.company.library.model.Book;
import io.company.library.repository.BookRepository;
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
        return bookRepository.findBookByTitle(title);
    }

    public Book deleteBookByTitle(String title){
        //Find out IF this id-book IS in our DB
        Optional<Book> deletedBook = bookRepository.deleteBookByTitle(title);
        //
        return null;
    }

    public void deleteBookById(Long id){
        bookRepository.deleteById(id);
    }

    public Book updateBook (Book book){
        return bookRepository.save(book);
    }




}