package io.company.library;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Scanner;

    @Component
    public class ApplicationCommandRunner implements CommandLineRunner {

        protected final Log logger = LogFactory.getLog(getClass());

        @Autowired
        BookService bookService;
        @Autowired
        AuthorService authorService;

        @Override
        public void run(String... args) throws Exception {

            Scanner reader = new Scanner(System.in);
            createBooksAndAuthors();
            //createOneBook(reader);

        }

        public void createBooksAndAuthors(){
            logger.info("Welcome to the createBooks");
            // String title, String author, int pages, int year, String iSBN
            Book book1 = new Book("Anna Karenina",  562, 1896, "BR5GV-5-ERG5-6567");
            Book book2 = new Book("To the lighthouse", 235, 1626, "56756-DFG2T-554");
            Book book3 = new Book("Orlando",  203, 2023, "4455645-GWR-456");
            Book book4 = new Book("In Search of Lost Time", 152, 2023, "4455645-GW1R-456");
            LocalDate date1 = LocalDate.of (1856,1,1);
            Author author1 = new Author("Leon", "Tolstoy", date1 );
            LocalDate date2 = LocalDate.of (1882,1,1);
            Author author2 = new Author("Virginia", "Wolf", date2 );

            //author1.addBook(book1);
            //book1.setAuthorId(author1);

            authorService.createAuthor(author1);
            authorService.createAuthor(author2);
            //to repo-DB via bookService
            bookService.createBook(book1);
            bookService.createBook(book2);
            bookService.createBook(book3);
            bookService.createBook(book4);



            logger.info("finishing createBooks ...");


        }



        public void createOneBook(Scanner reader){

            logger.info("Welcome to the createBook");

            System.out.println("Title? ");
            String title = reader.nextLine();
            System.out.println("Pages? ");
            int pages = reader.nextInt();
            System.out.println("Year Published? ");
            int publishedYear = reader.nextInt();
            System.out.println("ISBN? ");
            String isbn = reader.next();

            bookService.createBook(new Book(title, pages, publishedYear, isbn));

            logger.info("bookService called with new book ...");
            logger.info("finishing createBook ...");
        }

    }

