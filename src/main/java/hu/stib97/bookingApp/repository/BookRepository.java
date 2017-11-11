package hu.stib97.bookingApp.repository;

import hu.stib97.bookingApp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

}
