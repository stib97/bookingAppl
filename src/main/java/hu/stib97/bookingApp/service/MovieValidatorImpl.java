package hu.stib97.bookingApp.service;

import hu.stib97.bookingApp.model.Movie;
import hu.stib97.bookingApp.service.interfaces.MovieValidatorI;
import hu.stib97.bookingApp.service.interfaces.Validator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieValidatorImpl implements MovieValidatorI, Validator<Movie> {

    @Override
    public List<String> validate(Movie movie) {
        List<String> errors = new ArrayList<>();
        errors.addAll(validateTitle(movie.getCim()));
        errors.addAll(validateEv(movie.getEv()));
        return errors;
    }

    public List<String> validateTitle(String title) {
        List<String> errors = new ArrayList<>();
        if (title == null){
            errors.add(EMPTY_TITLE);
        }else if(title.equals("")){
            errors.add(EMPTY_TITLE);
        }
        return errors;
    }

    public List<String> validateEv(int ev) {
        List<String> errors = new ArrayList<>();
        if (ev < 1900 || ev > 2100) errors.add(BAD_EV);
        return errors;
    }
}
