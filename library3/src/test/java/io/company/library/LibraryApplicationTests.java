package io.company.library;

import io.company.library.model.Book;
import io.company.library.repository.BookRepository;
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
	BookService bookService;

	@Autowired
	BookRepository bookRepository;


	@Test
	void contextLoads() {
	}

	@Test
	void createBooks(){

		// String title, String author, int pages, int year, String iSBN
		Book book1 = new Book("Anna Karenina",  562, 1896, "BR5GV-5-ERG5-6567");
		Book book2 = new Book("To the lighthouse", 235, 1626, "56756-DFG2T-554");
		Book book3 = new Book("Orlando",  203, 2023, "4455645-GWR-456");
		Book book4 = new Book("In Search of Lost Time", 152, 2023, "4455645-GW1R-456");
		//to repo-DB via bookService
		bookService.createBook(book1);
		bookService.createBook(book2);
		bookService.createBook(book3);
		bookService.createBook(book4);

		assertEquals(bookRepository.count(), 4);

	}








}
