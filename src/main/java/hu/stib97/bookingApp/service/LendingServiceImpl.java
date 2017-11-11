package hu.stib97.bookingApp.service;

import hu.stib97.bookingApp.model.Book;
import hu.stib97.bookingApp.model.Lending;
import hu.stib97.bookingApp.model.Movie;
import hu.stib97.bookingApp.model.User;
import hu.stib97.bookingApp.repository.LendingRepository;
import hu.stib97.bookingApp.repository.UserRepository;
import hu.stib97.bookingApp.service.interfaces.LendingServiceI;
import hu.stib97.bookingApp.service.interfaces.LendingValidatorI;
import hu.stib97.bookingApp.service.interfaces.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LendingServiceImpl implements LendingServiceI {

    @Autowired
    public LendingRepository lendingRepository;

    @Autowired
    public LendingValidatorI validator;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public UserServiceI userService;


    @Override
    public void createLending(Lending lend) {
        List<String> errors = validator.validate(lend);
        if (errors.isEmpty()) {
            lendingRepository.save(lend);
             userService.addLending(lend.getUser(), lend);
        } else{
            System.out.println("Valamelyik adattagban hiba van!");
        }
    }

    @Override
    public void deleteLending(Lending lend){
        userService.removeLending(lend.getUser(),lend);
        lendingRepository.delete(lend);
    }

    @Override
    public List<Lending> getLendList() {
        return lendingRepository.findAll();
    }

    @Override
    public List<Movie> getMovieByUser(User user){
        List<Movie> ret = new ArrayList<>();
        for(Lending lend : lendingRepository.findByUser(user)){
            ret.add(lend.getMovie());
        }
        return ret;
    }

    @Override
    public List<Book> getBookyUser(User user){
        List<Book> ret = new ArrayList<>();
        for(Lending lend : lendingRepository.findByUser(user)){
            ret.add(lend.getBook());
        }
        return ret;
    }

    @Override
    public User getUserByMovie(Movie movie){
        User ret = null;
        for(Lending lend : lendingRepository.findAll()){
            if(lend.getMovie().equals(movie)){
                ret = lend.getUser();
            }
        }
        return ret;
    }

    @Override
    public User getUserByBook(Book book) {
        User ret = null;
        for (Lending lend : lendingRepository.findAll()) {
            if (lend.getBook().equals(book)) {
                ret = lend.getUser();
            }
        }
        return ret;
    }

}
