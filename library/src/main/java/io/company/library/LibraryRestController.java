package io.company.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("apilibrary")
public class LibraryRestController {
    @Autowired
    BookService bookservice;

    //here we are creating our end-point rest API
    @GetMapping("books")
    public List<Book> getAllBooks() {
        return bookservice.queryBooksFromArray();
    }


}
