package io.company.library.repository;

import io.company.library.model.Address;
import io.company.library.model.Book;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;


public interface AddressRepository extends CrudRepository<Address, Long> {
    //


}

