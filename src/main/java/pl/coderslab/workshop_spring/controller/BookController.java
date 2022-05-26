package pl.coderslab.workshop_spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.workshop_spring.entities.Book;
import pl.coderslab.workshop_spring.support_classes.MockBookService;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

    private final MockBookService mockBookService;

    public BookController(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }
    @GetMapping("")
    public List<Book> getBooks() {
        return mockBookService.getBooks();
    }
    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        mockBookService.addOne(book);
    }
    @GetMapping("/{id:\\d+}")
    public Book getBook(@PathVariable Long id) {
        return mockBookService.getBook(id);
    }
    @PutMapping("/{id:\\d+}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        if (!id.equals(book.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Path and body ids do not match");
        }
        mockBookService.updateBook(book);
        return book;
    }

    @DeleteMapping("/{id:\\d+}")
    public void deleteBook(@PathVariable Long id) {
        mockBookService.removeBook(id);
    }

}


