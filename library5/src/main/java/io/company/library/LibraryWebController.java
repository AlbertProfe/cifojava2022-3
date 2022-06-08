package io.company.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/library")
public class LibraryWebController {

    @Autowired
    BookService bookService;

    @RequestMapping("/books")
    public String getWeb (Model containerToView) {

        containerToView.addAttribute("booksfromController",
                bookService.getAllBooks());

        return "showBooks";
    }
    @RequestMapping("/newBook")
    public String newBook (){

        return "newBook";
    }


    @RequestMapping("/deleteBook")
    public String deleteBook(@RequestParam String titleFromView){

        System.out.println("titleFromView" + titleFromView);
        bookService.deleteBookByTitle(titleFromView);

        return "showBooks";


    }





}