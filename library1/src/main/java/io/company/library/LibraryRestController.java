package io.company.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        //
        Optional<Book> bookFound = bookservice.findBookById(id);
        if (bookFound.isPresent()) return  bookFound.get();

        return null;
    }

    //CRUD: create
    @PostMapping(path="addBook", consumes = "application/JSON")
    public Book addBook(@RequestBody Book book){
        //
        Book bookCreated = bookservice.createBook(book);
        return bookCreated ;
    }

    //CRUD: delete
    @DeleteMapping("deleteBook")
    public ResponseEntity<Book> deleteBook (@RequestParam Long id) {
        //
        Optional<Book> bookFound  = bookservice.findBookById(id);
        boolean isBook = bookFound.isPresent();
        if(isBook) {
            bookservice.deleteBookById(id);
            return  ResponseEntity.accepted().body(bookFound.get());
        } else return ResponseEntity.accepted().body(null);


    }

    //CRUD: update
    public ResponseEntity<Book> updateBook (@RequestBody Book bookToUpdate){
        //find book by id >> bookFound
        // if exists .... let s compare
        // field by field
        // bookToUpdate to bookFound
        //bookservice.updateBook():

        return null;
    }


}
