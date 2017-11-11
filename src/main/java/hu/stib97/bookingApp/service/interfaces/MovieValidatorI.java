package hu.stib97.bookingApp.service.interfaces;

import hu.stib97.bookingApp.model.Movie;

import java.util.List;

public interface MovieValidatorI {

    List<String> validate(Movie movie);

    List<String> validateTitle(String title);

    List<String> validateEv(int ev);
}
