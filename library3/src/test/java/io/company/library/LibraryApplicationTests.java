package io.company.library;

import io.company.library.model.Address;
import io.company.library.model.Book;
import io.company.library.model.Library;
import io.company.library.repository.AddressRepository;
import io.company.library.repository.BookRepository;
import io.company.library.repository.LibraryRepository;
import io.company.library.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LibraryApplicationTests {
	@Autowired
	BookRepository bookRepository;
	@Autowired
	LibraryRepository libraryRepository;
	@Autowired
	AddressRepository addressRepository;

	@Test
	void createBooks(){
		// String title, String author, int pages, int year, String iSBN
		Book book1 = new Book("Anna Karenina",  562, 1896, "BR5GV-5-ERG5-6567");
		Book book2 = new Book("To the lighthouse", 235, 1626, "56756-DFG2T-554");
		Book book3 = new Book("Orlando",  203, 2023, "4455645-GWR-456");
		Book book4 = new Book("In Search of Lost Time", 152, 2023, "4455645-GW1R-456");
		//to repo-DB via bookService
		bookRepository.save(book1);
		bookRepository.save(book2);
		bookRepository.save(book3);
		bookRepository.save(book4);

		assertEquals(bookRepository.count(), 4);

	}

	@Test
	void createLibraries() {
		//
		Library library1 = new Library("Volpelleres Library", 4520);
		Library library2 = new Library("Sagrada Familia Library", 5520);
       //
		libraryRepository.save(library1);
		libraryRepository.save(library2);

		assertEquals(libraryRepository.count(), 2);

	}

	@Test
	void createAddresses() {
		//
		Address address1 = new Address("c/Pau", 156, "08056");

		addressRepository.save(address1);




	}

	@Test
	void assignBookLibrary(){
		Book book1 = new Book("Quardern Gris",  452, 1965, "BR5GV-5-ERG5-6567");
		bookRepository.save(book1);

		Library library1 = new Library("Eixample Library", 4520);
		libraryRepository.save(library1);

		//to-do
		//book1.addLibrary(libarary1);
		//assgin library1 to book1 through getter list libraries
		book1.getLibraries().add(library1);
		bookRepository.save(book1);




	}




}
