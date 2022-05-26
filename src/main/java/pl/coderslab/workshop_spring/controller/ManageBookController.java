package pl.coderslab.workshop_spring.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.workshop_spring.entities.Book;
import pl.coderslab.workshop_spring.support_classes.BookService;

import java.util.List;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {

    private final BookService bookService;

    public ManageBookController(@Qualifier("jpaBookService") BookService bookService) {
        this.bookService = bookService;
    }

    // Displaying books
    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "/all";
    }

    // Adding book
    @GetMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "add";
    }

    @PostMapping("/add")
    public String processAddedBook(Book book) {
        bookService.addOne(book);
        return "redirect:/admin/books/all";
    }

    // Editing book
    @GetMapping("/edit/{id}")
    public String editBook(Model model, @PathVariable long id) {
        model.addAttribute("book", bookService.getBook(id));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String processEditedBook(Book book) {
        bookService.updateBook(book);
        return "redirect:/admin/books/all";
    }

    // Removing book
    @GetMapping("/delete/{id}")
    public String removeBook(@PathVariable long id) {
        bookService.removeBook(id);
        return "redirect:/admin/books/all";
    }

    // Display single book
    @GetMapping("/get/{id}")
    public String getBook(@PathVariable long id, Model model) {
        Book book = bookService.getBook(id);
        model.addAttribute("book", book);
        return "show";
    }

}
