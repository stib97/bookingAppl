package hu.stib97.bookingApp.api;

import hu.stib97.bookingApp.model.Movie;
import hu.stib97.bookingApp.security.Role;
import hu.stib97.bookingApp.service.interfaces.MovieServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static hu.stib97.bookingApp.security.UserRole.ADMIN;

@RestController
@RequestMapping("api/movie")
public class MovieController {

    @Autowired
    private MovieServiceI movieService;

    @Role(ADMIN)
    @PutMapping("create")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        movieService.createMovie(movie);

        return ResponseEntity.ok(movie);
    }

    @Role(ADMIN)
    @PostMapping("editTitle/{title}")
    public ResponseEntity<Movie> editTitle(@RequestBody Movie movie, @RequestParam String title) {
        movieService.editTitle(movie, title);

        return ResponseEntity.ok(movie);
    }

    @Role(ADMIN)
    @PostMapping("editEv/{ev}")
    public ResponseEntity<Movie> editEv(@RequestBody Movie movie, @RequestParam int ev) {
        movieService.editEv(movie, ev);

        return ResponseEntity.ok(movie);
    }

    @Role(ADMIN)
    @PostMapping("delete")
    public ResponseEntity<Movie> delete(@RequestBody Movie movie) {
        movieService.delete(movie);

        return ResponseEntity.ok(movie);
    }


}
