package hu.stib97.bookingApp.service;

import hu.stib97.bookingApp.model.Lending;
import hu.stib97.bookingApp.model.User;
import hu.stib97.bookingApp.service.interfaces.LendingValidatorI;
import hu.stib97.bookingApp.service.interfaces.UserValidatorI;
import hu.stib97.bookingApp.service.interfaces.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LendingValidatorImpl implements LendingValidatorI, Validator<Lending> {

    @Autowired
    public UserValidatorI userValidator;

    @Override
    public List<String> validate(Lending lend) {
        List<String> errors = new ArrayList<>();
        errors.addAll(validateUser(lend.getUser()));
        errors.addAll(validateDate(lend.getDate()));
        return errors;
    }

    public List<String> validateUser(User user){
       return userValidator.validate(user);
    }

    public List<String> validateDate(Date date) {
        List<String> errors = new ArrayList<>();
        if (date == null) errors.add(EMPTY_DATE);
        return errors;
    }


}
