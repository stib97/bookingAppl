package hu.stib97.bookingApp.service.interfaces;

import hu.stib97.bookingApp.model.Movie;

import java.util.List;

public interface MovieServiceI {

    void createMovie(Movie movie);

    void delete(Movie movie);

    String editTitle(Movie movie, String newTitle);

    int editEv(Movie movie, int ev);

    List<Movie> getMovies();


}
