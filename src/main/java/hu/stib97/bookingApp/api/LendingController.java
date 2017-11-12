package hu.stib97.bookingApp.api;


import hu.stib97.bookingApp.model.Book;
import hu.stib97.bookingApp.model.Lending;
import hu.stib97.bookingApp.model.Movie;
import hu.stib97.bookingApp.model.User;
import hu.stib97.bookingApp.security.Role;
import hu.stib97.bookingApp.service.interfaces.LendingServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static hu.stib97.bookingApp.security.UserRole.ADMIN;
import static hu.stib97.bookingApp.security.UserRole.USER;

@RestController
@RequestMapping("api/lending")
public class LendingController {

    @Autowired
    private LendingServiceI lendingService;

    @Role({USER,ADMIN})
    @PutMapping("create")
    public ResponseEntity<Lending> createLending(@RequestBody Lending lend) {
        lendingService.createLending(lend);

        return ResponseEntity.ok(lend);
    }

    @Role(ADMIN)
    @PostMapping("delete")
    public ResponseEntity<Void> deleteLending(@RequestBody Lending lend) {
//        lendingService.deleteLending(,lend);

        return ResponseEntity.ok().build();
    }

    @Role({USER,ADMIN})
    @GetMapping("list")
    public ResponseEntity<List<Lending>> getLendList() {
        List<Lending> lendList = lendingService.getLendList();

        return ResponseEntity.ok(lendList);
    }

    @Role({USER,ADMIN})
    @PostMapping("moviesByUser")
    public ResponseEntity<List<Movie>> getMovieByUser(@RequestBody User user) {
        List<Movie> movieByUser = lendingService.getMovieByUser(user);

        return ResponseEntity.ok(movieByUser);

    }

    @Role({USER,ADMIN})
    @PostMapping("booksByUser")
    public ResponseEntity<List<Book>> getBookyUser(@RequestBody User user) {
        List<Book> bookyUser = lendingService.getBookyUser(user);

        return ResponseEntity.ok(bookyUser);
    }

    @Role(ADMIN)
    @PostMapping("userByMovie")
    public ResponseEntity<User> getUserByMovie(@RequestBody Movie movie) {
        User userByMovie = lendingService.getUserByMovie(movie);

        return ResponseEntity.ok(userByMovie);
    }

    @Role(ADMIN)
    @PostMapping("userByBook")
    public ResponseEntity<User> getUserByBook(@RequestBody Book book) {
        User userByBook = lendingService.getUserByBook(book);

        return ResponseEntity.ok(userByBook);
    }
}
