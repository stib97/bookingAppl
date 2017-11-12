package hu.stib97.bookingApp.api;

import hu.stib97.bookingApp.model.Book;
import hu.stib97.bookingApp.security.Role;
import hu.stib97.bookingApp.security.UserRole;
import hu.stib97.bookingApp.service.interfaces.BookServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static hu.stib97.bookingApp.security.UserRole.USER;

/**
 * @author Steinebrunner Ibolya on 2017. 11. 12.
 */
@RestController
@RequestMapping("api/book")
public class BookController {

    @Autowired
    private BookServiceI bookService;

    @Role(UserRole.ADMIN)
    @PostMapping("editIro/{iro}")
    public ResponseEntity<Book> editIro(@RequestBody Book book, @RequestParam String iro) {
        bookService.editIro(book, iro);

        return ResponseEntity.ok(book);
    }

    @Role(UserRole.ADMIN)
    @PostMapping("editTitle/{iro}")
    public ResponseEntity<Book> editTitle(@RequestBody Book book, @RequestParam String title) {
        bookService.editTitle(book, title);

        return ResponseEntity.ok(book);
    }

    @Role(UserRole.ADMIN)
    @PostMapping("delete")
    public ResponseEntity<Void> delete(@RequestBody Book book) {
        bookService.delete(book);

        return ResponseEntity.ok().build();
    }

    @Role(UserRole.ADMIN)
    @PutMapping("create")
    public ResponseEntity<Void> createBook(@RequestBody Book book) {
        bookService.createBook(book);

        return ResponseEntity.ok().build();
    }
}
