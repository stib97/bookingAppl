package hu.stib97.bookingApp.service.interfaces;

import hu.stib97.bookingApp.model.Lending;
import java.util.List;

public interface LendingValidatorI {

    List<String> validate(Lending lend);
}
