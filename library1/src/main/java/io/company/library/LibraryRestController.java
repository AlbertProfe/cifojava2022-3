package io.company.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class LibraryRestController {

    @Autowired
    BookService bookservice;

    //here we are creating our end-point rest API
    //CRUD: read
    @GetMapping("books")
    public Iterable<Book> getAllBooks() {
        //
        return bookservice.getAllBooks();
    }

    //CRUD: read, find one book by id
    @GetMapping("getBook")
    public Book findBookById(Long id){

        Optional<Book> bookFound = bookservice.findBookById(id);
        if (bookFound.isPresent()) return  bookFound.get();

        return null;
    }

    //CRUD: create
    @PostMapping("addBook")
    public Book addBook(Book book){

        Book bookCreated = bookservice.createBook(book);

        return bookCreated ;
    }

    //CRUD: delete
    @DeleteMapping("deleteBook")
    public Book deleteBook (Long id){

        bookservice.deleteBookById(id);

        return null;
    }


    //CRUD: update


}
