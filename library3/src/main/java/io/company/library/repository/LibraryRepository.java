package io.company.library.repository;

import io.company.library.model.Book;
import io.company.library.model.Library;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface LibraryRepository extends CrudRepository<Library, Long> {
    //
    Optional<Library> findBookByName(String name);
    Optional<Library> deleteBookByName(String name);

}

