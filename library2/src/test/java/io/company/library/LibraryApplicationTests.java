package io.company.library;

import io.company.library.model.Author;
import io.company.library.model.Book;
import io.company.library.repository.AuthorRepository;
import io.company.library.repository.BookRepository;
import io.company.library.service.AuthorService;
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
	AuthorService authorService;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	AuthorRepository authorRepository;

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

	@Test
	void createAuthors(){

		LocalDate date1 = LocalDate.of (1856,1,10);
		Author author1 = new Author("Leon", "Tolstoy", date1 );
		LocalDate date2 = LocalDate.of (1882,1,12);
		Author author2 = new Author("Virginia", "Wolf", date2 );
		LocalDate date3 = LocalDate.of (1782,1,5);
		Author author3 = new Author("Emile", "Zona", date2 );
		//to repo-DB via authorService
		authorService.createAuthor(author1);
		authorService.createAuthor(author2);
		authorService.createAuthor(author3);

		assertEquals(authorRepository.count(), 3);

	}

	@Test
	void assignAuthorToNewBooks(){
		//find by id just one author
		Optional<Author> authorFound = authorRepository.findById(47L);
		//if author exists, then..
		if(authorFound.isPresent()) {
			//create books
			Book book1 = new Book("War and Peace",  462, 1867, "SSSGV-5-ERG5-6567");
			Book book2 = new Book("Chilhood", 235, 1852, "56756-DFG2T-554");
			//assign author to books
			book1.setAuthorId(authorFound.get());
			book2.setAuthorId(authorFound.get());
			//save books with author
			bookService.createBook(book1);
			bookService.createBook(book2);
		}

	}

	@Test
	void assignNewBooksToAuthor(){
		//find by id just one author
		Optional<Author> authorFound = authorRepository.findById(5L);
		//if author exists, then..
		if(authorFound.isPresent()) {
			//create books
			Book book1 = new Book("War and Peace",  462, 1867, "SSSGV-5-ERG5-6567");
			Book book2 = new Book("Chilhood", 235, 1852, "56756-DFG2T-554");
			//save books without author
			bookService.createBook(book1);
			bookService.createBook(book2);
			//assign author to books
			authorFound.get().addBook(book1);
			authorFound.get().addBook(book2);

			authorService.createAuthor(authorFound.get());

		}
	}

	@Test
	void createAuthorAndNewBooks(){
			//create books
			Book book1 = new Book("La comédie humaine 1",  462, 1842, "SSSGV-5-ERG5-6567");
			Book book2 = new Book("La comédie humaine 2", 235, 1842, "56756-DFG2T-554");
			//save books without author
			bookService.createBook(book1);
			bookService.createBook(book2);

		    LocalDate date3 = LocalDate.of (1822,1,4);
			Author author1 = new Author("Honore","Balzec",date3 );

			authorService.createAuthor(author1);

			author1.addBook(book1);
			author1.addBook(book2);

			authorService.createAuthor(author1);
		}



}
