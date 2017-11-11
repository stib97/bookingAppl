package hu.stib97.bookingApp.service.interfaces;

import hu.stib97.bookingApp.model.Book;
import hu.stib97.bookingApp.model.Lending;
import hu.stib97.bookingApp.model.Movie;
import hu.stib97.bookingApp.model.User;

import java.util.List;

public interface LendingServiceI {

    void createLending(Lending lend);

    void deleteLending(Lending lend);

    List<Lending> getLendList();

    List<Movie> getMovieByUser(User user);

    List<Book> getBookyUser(User user);

    User getUserByMovie(Movie movie);

    User getUserByBook(Book book);




}
