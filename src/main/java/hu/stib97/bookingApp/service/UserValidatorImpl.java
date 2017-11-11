package hu.stib97.bookingApp.service;

import hu.stib97.bookingApp.model.User;
import hu.stib97.bookingApp.service.interfaces.UserValidatorI;
import hu.stib97.bookingApp.service.interfaces.Validator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserValidatorImpl implements Validator<User>, UserValidatorI {

    @Override
    public List<String> validate(User user) {
        List<String> errors = new ArrayList<>();
        errors.addAll(validateName(user.getName()));
        errors.addAll(validateEmail(user.getEmailAddress()));
        errors.addAll(validatePassword(user.getPassword()));
        return errors;
    }

    @Override
    public List<String> validateName(String name) {
        List<String> errors = new ArrayList<>();
        if("".equals(name)){
            errors.add(EMPTY_NAME);
        }
        else if(name == null){
            errors.add(EMPTY_NAME);
        }
        return errors;
    }

    @Override
    public List<String> validateEmail(String email) {
        List<String> errors = new ArrayList<>();
        if("".equals(email)){
            errors.add(EMPTY_EMAIL);
        }
        else if(email == null){
            errors.add(EMPTY_EMAIL);
        }
        return errors;
    }

    @Override
    public List<String> validatePassword(String password) {
        List<String> errors = new ArrayList<>();
        if("".equals(password)){
            errors.add(EMPTY_PW);
        }
        else if(password == null){
            errors.add(EMPTY_PW);
        }
        return errors;
    }
}
