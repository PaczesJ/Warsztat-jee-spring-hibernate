package pl.coderslab.workshop_spring.support_classes;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.workshop_spring.entities.Book;

import java.util.List;

@Primary
@Service
public class JpaBookService implements BookService{

    private final BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
    @Override
    public void addOne(Book book) {
        bookRepository.save(book);
    }
    @Override
    public Book getBook(Long id) {
        return bookRepository.getOne(id);
    }
    @Override
    public void updateBook(Book bookToUpdate) {
        bookRepository.save(bookToUpdate);
    }
    @Override
    public void removeBook(Long id) {
        Book one = bookRepository.getOne(id);
        bookRepository.delete(one);
    }
}
