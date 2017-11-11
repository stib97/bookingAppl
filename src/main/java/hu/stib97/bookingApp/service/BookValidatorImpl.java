package hu.stib97.bookingApp.service;

import hu.stib97.bookingApp.model.Book;
import hu.stib97.bookingApp.service.interfaces.BookValidatorI;
import hu.stib97.bookingApp.service.interfaces.Validator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookValidatorImpl implements BookValidatorI, Validator<Book> {


    @Override
    public List<String> validate(Book book) {
        List<String> errors = new ArrayList<>();
        errors.addAll(validateTitle(book.getCim()));
        errors.addAll(validateIro(book.getIro()));
        return errors;
    }

    @Override
    public List<String> validateTitle(String title) {
        List<String> errors = new ArrayList<>();
        if (title == null){
            errors.add(EMPTY_TITLE);
        }else if(title.equals("")){
            errors.add(EMPTY_TITLE);
        }
        return errors;
    }

    @Override
    public List<String> validateIro(String iro) {
        List<String> errors = new ArrayList<>();
        if (iro == null) {
            errors.add(EMPTY_IRO);
        } else if (iro.equals("")) {
            errors.add(EMPTY_IRO);
        }
        return errors;
    }
}
