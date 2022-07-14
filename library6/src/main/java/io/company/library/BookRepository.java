package io.company.library;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
//public interface BookRepository extends CrudRepository <Book, Long> {
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {


}

