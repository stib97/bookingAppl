package hu.stib97.bookingApp.service.interfaces;

import hu.stib97.bookingApp.model.User;

import java.util.List;

public interface UserValidatorI {

    List<String> validateName(String name);

    List<String> validateEmail(String email);

    List<String> validatePassword(String password);

    List<String> validate(User user);
}
