package io.company.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/library")
public class LibraryWebController {

    @Autowired
    BookService bookService;

    @RequestMapping("/books")
    public String getWeb(Model containerToView) {
        //
        containerToView.addAttribute("booksfromController",
                bookService.getAllBooks());
        return "showBooks";
    }

    @RequestMapping("/newBook")
    public String newBook() {
        return "newBook";
    }

    @RequestMapping("/insertBook")
    public String insertBook(Book book) {
        //
        bookService.createBook(book);
        return "redirect:books";
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(@RequestParam("bookIdFromView") Long id) {
        //
        bookService.deleteBookById(id);
        return "redirect:books";
    }

    @RequestMapping("/updateBook")
    public String updateBook(@RequestParam("bookIdFromView") Long id, Model model) {
        //
        Optional<Book> bookFound = bookService.findBookById(id);
        if (bookFound.isPresent()) {
            model.addAttribute("bookfromController", bookFound.get());
            return "updateBook";
        } else return "notfound.html";
    }

    @RequestMapping("/detailBook")
    public String detailBook(@RequestParam("bookIdFromView") Long id) {
        //
        //bookService.updaetBookById(id);
        return "detailBook";
    }

}




