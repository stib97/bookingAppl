package hu.stib97.bookingApp.service.interfaces;

import hu.stib97.bookingApp.model.Book;

import java.util.List;

public interface BookValidatorI {

    List<String> validate(Book book);

    List<String> validateTitle(String title);

    List<String> validateIro(String iro);
}
