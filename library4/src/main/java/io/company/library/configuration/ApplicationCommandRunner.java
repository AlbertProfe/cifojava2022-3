package io.company.library.configuration;

import io.company.library.model.Book;
import io.company.library.service.BookService;
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
            //
            Scanner reader = new Scanner(System.in);
            //createOneBook(reader);
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

