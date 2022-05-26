package pl.coderslab.workshop_spring.support_classes;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.workshop_spring.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
