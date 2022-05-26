package pl.coderslab.workshop_spring.support_classes;

import pl.coderslab.workshop_spring.entities.Book;

import java.util.List;

public interface BookService {

    List<Book> getBooks();

    void addOne(Book book);

    Book getBook(Long id);

    void updateBook(Book bookToUpdate);

    void removeBook(Long id);
}
