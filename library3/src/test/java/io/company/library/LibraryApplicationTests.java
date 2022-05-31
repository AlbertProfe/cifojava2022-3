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
		Book b1 = bookRepository.save(book1);
		Book b2 = bookRepository.save(book2);
		Book b3 = bookRepository.save(book3);
		Book b4 = bookRepository.save(book4);

		assertEquals(book1, b1);
		assertEquals(book2, b2);
		assertEquals(book3, b3);
		assertEquals(book4, b4);

		System.out.println("Count books: " + bookRepository.count());
	}

	@Test
	void createLibraries() {
		//
		Library library1 = new Library("Volpelleres Library", 4520);
		Library library2 = new Library("Sagrada Familia Library", 5520);
       //
		Library l1 = libraryRepository.save(library1);
		Library l2 = libraryRepository.save(library2);

		assertEquals(l1, library1);
		assertEquals(l2, library2);

		System.out.println("Count libraries: " + libraryRepository.count());

	}

	@Test
	void createAddresses() {
		//
		Address address1 = new Address("c/Pau", 156, "08056");
		Address a1 = addressRepository.save(address1);
		assertEquals(a1, address1);

		System.out.println("Count addresses: " + addressRepository.count() );

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
		//because it is bidirectional we may assign book to library
		//but be CAREFUL we are repeating a record ...
		library1.getBooks().add(book1);
		bookRepository.save(book1);
		libraryRepository.save(library1);

	}

	@Test
	void assignAddressLibrary(){
		Library library1 = new Library("Sant Andreu Library", 4520);
		libraryRepository.save(library1);
		Address address1 = new Address("c/Llibertat", 1, "08026");
		addressRepository.save(address1);
		//to-do
		//book1.addLibrary(libarary1);
		//assgin library1 to book1 through getter list libraries
		address1.setLibrary(library1);
		addressRepository.save(address1);

	}




}
