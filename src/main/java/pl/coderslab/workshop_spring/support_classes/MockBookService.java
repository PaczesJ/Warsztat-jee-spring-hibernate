package pl.coderslab.workshop_spring.support_classes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.workshop_spring.entities.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Primary
public class MockBookService implements BookService {

    private static final Logger log = LoggerFactory.getLogger(MockBookService.class);
    private List<Book> books;
    private static Long nextId = 4L;

    public MockBookService() {
        log.info("Tworzenie listy książek...");
        books = new ArrayList<>();
        books.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "programming", "Helion",
                "Bruce	Eckel"));
        books.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Helion", "programming",
                "Sierra	Kathy,	Bates	Bert"));
        books.add(new Book(3L, "9780130819338", "Java	2.	Podstawy",  "Helion" ,"programming",
                "Cay	Horstmann,	Gary	Cornell"));
        log.info("Utworzono listę książek: {} ", books);
    }

    // Pobieranie listy książek
    @Override
    public List<Book> getBooks() {
        return books;
    }
    // Dodanie książki
    @Override
    public void addOne(Book book) {
        log.debug("Dodawanie książki: {} ", book);
        book.setId(nextId);
        log.debug("Ustalone id dla książki: {} ", book.getId());
        this.books.add(book);
        nextId++;
    }
    // Pobieranie obiektu po wskazanym identyfikatorze
    @Override
    public Book getBook(Long id) {
        log.debug("Pobieranie książki o id: {} ", id);
        Book foundBook = books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
        log.debug("Znaleziona książka: {} ", foundBook);
        return foundBook;
    }
    // Edycja obiektu

    @Override
    public void updateBook(Book bookToUpdate) {
        log.debug("Aktualizacja książki: {}", bookToUpdate);
        books.stream()
                .filter(b-> b.getId().equals(bookToUpdate.getId()))
                .map(books::indexOf)
                .findFirst()
                .ifPresentOrElse(
                        index -> books.set(index, bookToUpdate),
                        () -> {
                            throw new NoSuchElementException();
                        }
                );
        log.debug("Lista książek po aktualizacji: {}", books.size());

    }
    // Usuwanie obiektu
    @Override
    public void removeBook(Long id) {
        log.debug("Liczba książek przed usunięciem: {}", books.size());
        books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .ifPresentOrElse(
                        books::remove,
                        () -> {throw new NoSuchElementException();
                        }
                );
        log.debug("Liczba książek po usunięciu: {}", books.size());

    }
}
