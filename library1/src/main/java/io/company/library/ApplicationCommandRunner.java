package io.company.library;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Scanner;

    @Component
    public class ApplicationCommandRunner implements CommandLineRunner {

        protected final Log logger = LogFactory.getLog(getClass());

        @Autowired
        BookService bookService;

        @Override
        public void run(String... args) throws Exception {

            Scanner reader = new Scanner(System.in);
            //createBooks();
            //createFakerBooks();
            //createOneBook(reader);

        }

        public void createBooks(){
            logger.info("Welcome to the createBooks");
            // String title, String author, int pages, int year, String iSBN
            Book book1 = new Book("Anna Karenina", "Tolstoy", 562, 1896, "BR5GV-5-ERG5-6567");
            Book book2 = new Book("To the lighthouse", "V Wolf", 235, 1626, "56756-DFG2T-554");
            Book book3 = new Book("Orlando", "Virginia Wolf", 203, 2023, "4455645-GWR-456");
            Book book4 = new Book("In Search of Lost Time", "Marcel Proust", 152, 2023, "4455645-GW1R-456");
            //to repo-DB via bookService
            bookService.createBook(book1);
            bookService.createBook(book2);
            bookService.createBook(book3);
            bookService.createBook(book4);

            logger.info("finishing createBooks ...");


        }

        public void createFakerBooks(){
            logger.info("Welcome to the createFakerBooks");


            logger.info("finishing createFakerBooks ...");


        }

        public void createOneBook(Scanner reader){

            logger.info("Welcome to the createBook");

            System.out.println("Title? ");
            String title = reader.nextLine();
            System.out.println("Author? ");
            String author = reader.nextLine();
            System.out.println("Pages? ");
            int pages = reader.nextInt();
            System.out.println("Year Published? ");
            int publishedYear = reader.nextInt();
            System.out.println("ISBN? ");
            String isbn = reader.next();

            bookService.createBook(new Book(title, author, pages, publishedYear, isbn));

            logger.info("bookService called with new book ...");
            logger.info("finishing createBook ...");
        }

    }

