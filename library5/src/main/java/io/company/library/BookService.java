package io.company.library;


import java.util.ArrayList;
import java.util.List;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    static List<Book> books = new ArrayList<Book>();

    static {
        //String title, String author, int pages, int year, String iSBN
        Book book1 = new Book("Anna Karenina", "Tolstoy", 562, 1896, "BR5GV-5-ERG5-6567");
        Book book2 = new Book("To the lighthouse", "V Wolf", 235, 1626, "56756-DFGRT-554");
        Book book3 = new Book("I Love Java", "Anna Polinskaia", 256, 2023, "GWR-456");
        //Book book4 = new Book ();
        //Book book5 = new Book ();
        //Book book6 = new Book ();
        books.add(book3);
        books.add(book2);
        books.add(book1);

        Faker faker = new Faker();

       for (int i = 0; i <1000 ; i++ ){
           books.add(new Book (faker.book().title(),faker.book().author(), faker.number().numberBetween(100, 1250),
                   faker.number().numberBetween(1550, 2022),
                   String.format(faker.number().digits(5).toString() + "-ERUMR-" +  faker.number().digits(5).toString() ) ));
;       }

    }

    public List<Book> queryBooksFromArray() {

        //System.out.println("Books" + books);

        return books;
    }




}