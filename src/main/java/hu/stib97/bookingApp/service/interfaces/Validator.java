package hu.stib97.bookingApp.service.interfaces;

import java.util.List;


public interface Validator<T> {

    String EMPTY_NAME = "User name is empty.";
    String EMPTY_EMAIL = "Email is empty.";
    String NOT_STRING = "Emailaddress is number.";
    String EMPTY_PW = "Passwrd is empty!";
    String EMPTY_DATE = "Empty date!";
    String EMPTY_TITLE = "Empty title!";
    String BAD_EV = "Bad date!";
    String EMPTY_IRO = "Bad data!";
    List<String> validate(T obj);
}

