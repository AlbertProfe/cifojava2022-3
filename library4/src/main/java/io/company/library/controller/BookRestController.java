package io.company.library.controller;

import io.company.library.service.BookService;
import io.company.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class BookRestController {
    //here we are creating our end-point rest API
    @Autowired
    BookService bookservice;

    //CRUD: read
    @GetMapping("books")
    public ResponseEntity<Iterable<Book>> getAllBooks() {
        //with Headers and ResponseEntity
        var headers = new HttpHeaders();
        headers.add("ResponseGet", "findAll books executed");
        headers.add("version", "1.0 Api Rest Book Object");

        return ResponseEntity.accepted().headers(headers).body( bookservice.getAllBooks());
    }

    //CRUD: read, find one book by id
    @GetMapping("getBook")
    public ResponseEntity<Book> findBookById(Long id){
        //with Headers and ResponseEntity
        var headers = new HttpHeaders();
        headers.add("ResponseGet", "find book executed");
        headers.add("version", "1.0 Api Rest Book Object");

        Optional<Book> bookFound = bookservice.findBookById(id);
        if (bookFound.isPresent()) return ResponseEntity.accepted().headers(headers).body( bookFound.get());
        else return ResponseEntity.notFound().headers(headers).build();

    }

    //CRUD: create
    @PostMapping(path="addBook", consumes = "application/JSON")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        //with Headers and ResponseEntity
        var headers = new HttpHeaders();
        headers.add("ResponseCreate", "save Book executed");
        headers.add("version", "1.0 Api Rest User Object");

        Book bookCreated = bookservice.createBook(book);
        if (bookCreated != null) {
            headers.add("Executed Output", "user created");
            return ResponseEntity.accepted().headers(headers).body(bookCreated);
        } else {
            headers.add("Executed Output", "user NOT created");
            return ResponseEntity.internalServerError().headers(headers).build();
        }
    }

    //CRUD: delete
    @DeleteMapping("deleteBook")
    public ResponseEntity<Book> deleteBook (@RequestParam Long id) {
        //with Headers and ResponseEntity
        HttpHeaders headers = new HttpHeaders();
        headers.add("operation","deleteBook");
        headers.add("version","api 1.0");

        Optional<Book> bookFound  = bookservice.findBookById(id);
        boolean isBook = bookFound.isPresent();
        if(isBook) {
            //Optional<Book> deletedBook = bookservice.deleteBookById(id);
            bookservice.deleteBookById(id);
            headers.add("operationStatus","deleted");
            return  ResponseEntity.accepted().headers(headers).body(bookFound.get());
        } else {
            headers.add("operationStatus","not deleted, not found");
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

    //CRUD: update
    @PutMapping("/updateBook/{id}")
    public ResponseEntity<Book> updateBook (@PathVariable Long id, @RequestBody Book dataBook) {
        String responseUpdate = "";
        Optional<Book> bookFound = bookservice.findBookById(id);
        Book bookToUpdate =null;
        Book bookUpdated =null;

        if (bookFound.isPresent()) {
            bookToUpdate = bookFound.get();
            //we are going to compare both books:
            //bookFromRest vs bookToUpdate
            //we need to compare each field of our object
            responseUpdate += "book found";
            boolean updated = false;
            //title to update
            if  (dataBook.getTitle() != null) {
                responseUpdate += " - book title value updated: " + dataBook.getTitle()  +  "( old value: " + bookToUpdate.getTitle() + ")" ;
                bookToUpdate.setTitle(dataBook.getTitle());
                updated = true;
            }
            //title to update
            if  (dataBook.getIsbn() != null) {
                responseUpdate += " - ISBN value updated: " + dataBook.getIsbn()  +  "( old value: " + bookToUpdate.getIsbn() + ")" ;
                bookToUpdate.setIsbn(dataBook.getIsbn());
                updated = true;
            }
            //update yearPublished
            if  (dataBook.getPublishedYear() != 0) {
                responseUpdate += " - year int value updated: " + dataBook.getPublishedYear() +  "( old value: " + bookToUpdate.getPublishedYear()  + ")" ;
                bookToUpdate.setPublishedYear(dataBook.getPublishedYear());
                updated = true;
            }
            //update pages
            if  (dataBook.getPages() != 0) {
                responseUpdate += " - pages int value updated: " + dataBook.getPages() +  "( old value: " + bookToUpdate.getPages()  + ")" ;
                bookToUpdate.setPages(dataBook.getPages());
                updated = true;
            }

            if (!updated) responseUpdate += " - try to update but any field updated - something wrong happened";
            else { bookUpdated = bookservice.updateBook(bookToUpdate);}

        } else { responseUpdate = responseUpdate + "book not found";}

        var headers = new HttpHeaders();
        headers.add("ResponseUpdate", "updateBook executed");
        headers.add("version", "1.0 Api Rest User Object");
        headers.add("Executed Output", responseUpdate);

        return ResponseEntity.accepted().headers(headers).body(bookUpdated);
    }

    //CRUD: delete book by title
    //to-do
    @DeleteMapping("deleteBookByTitle")
    public ResponseEntity<Book> deleteBookByTitle (@RequestParam String title) {
        //
        HttpHeaders headers = new HttpHeaders();
        headers.add("operation","deleteBookByTitle");
        headers.add("version","api 1.0");

        //findBookByTitle(String title)
        //deleteBookByTitle(String title)

        return null;
    }

}
