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
        BookService bookservice;

        @Override
        public void run(String... args) throws Exception {

            logger.info("Welcome to the runner from commandLineRunner");


            // String title, String author, int pages, int year, String iSBN
            Book book1 = new Book(1,"Anna Karenina", "Tolstoi", 562, 1896, "BR5GV-5-ERG5-6567");
            Book book2 = new Book(2,"To the lighthouse", "V Wolf", 235, 1626, "56756-DFGRT-554");
            Book book3 = new Book(3,"Oralndo", "Virginia Wolf", 203, 2023, "4455645-GWR-456");
            Book book4 = new Book(4,"In Search of Lost Time", "Marcel Proust", 152, 2023, "4455645-GWR-456");

            bookservice.createBook(book1);
            bookservice.createBook(book2);
            bookservice.createBook(book3);
            bookservice.createBook(book4);

            logger.info("executing ...");

            Scanner reader = new Scanner(System.in);
            System.out.println("Reading hello Spring Boot Command Line Runner: " + reader.nextLine());


        }
    }

