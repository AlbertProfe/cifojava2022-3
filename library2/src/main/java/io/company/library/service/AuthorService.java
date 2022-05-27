package io.company.library.service;

import io.company.library.model.Author;
import io.company.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

    @Service
    public class AuthorService {

        @Autowired
        AuthorRepository authorRepository;

        public Iterable<Author> getAllAuthors() {

            Iterable<Author> authors = authorRepository.findAll();

            return authors;
        }

        public Author createAuthor (Author author){

            Author authorCreated = authorRepository.save(author);

            return authorCreated;
        }

        public Optional<Author> findAuthorById(Long id){

            return authorRepository.findById(id);
        }


}
