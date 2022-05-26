package io.company.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api")
public class AuthorRestController {

    @Autowired
    AuthorService authorService;

    //CRUD: read
    @GetMapping("authors")
    public Iterable<Author> getAllAuthors() {
        //
        return authorService.getAllAuthors();
    }

    //CRUD: read, find one author by id
    @GetMapping("getAuthor")
    public Author findAuthorById(Long id){
        //
        Optional<Author> authorFound = authorService.findAuthorById(id);
        if (authorFound.isPresent()) return authorFound.get();

        return null;
    }

    //CRUD: create
    @PostMapping(path="addAuthor", consumes = "application/JSON")
    public Author addAuthor(@RequestBody Author author){
        //
        Author authorCreated = authorService.createAuthor(author);
        return authorCreated ;
    }
}
