package hu.stib97.bookingApp.service;

import hu.stib97.bookingApp.model.Lending;
import hu.stib97.bookingApp.model.Movie;
import hu.stib97.bookingApp.repository.LendingRepository;
import hu.stib97.bookingApp.repository.MovieRepository;
import hu.stib97.bookingApp.service.interfaces.MovieServiceI;
import hu.stib97.bookingApp.service.interfaces.MovieValidatorI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieServiceI {

    @Autowired
    public MovieRepository movieRepository;

    @Autowired
    public LendingRepository lendingRepository;

    @Autowired
    public MovieValidatorI validator;

    @Override
    public void createMovie(Movie movie){
        List<String> errors = validator.validate(movie);
        if(errors.isEmpty()){
            movieRepository.save(movie);
        }
        else{
            System.out.println("Hiba van valamelyik adattagban!");
        }
    }

    @Override
    public void delete(Movie movie){
        boolean kivan = false;
        for(Lending lend : lendingRepository.findAll()){
            if(lend.getMovie().equals(movie)){
                kivan=true;
                System.out.println("Ki van kölcsönözve, nem törölhető");
            }

        }
        if(kivan = false){
            movieRepository.delete(movie);
        }
    }

    @Override
    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    @Override
    public String editTitle(Movie movie, String newTitle){
        List<String> error = validator.validateTitle(newTitle);
        if(error.isEmpty()){
            movie.setCim(newTitle);
            movieRepository.saveAndFlush(movie);
        }
        return newTitle;
    }

    @Override
    public int editEv(Movie movie, int ev){
        List<String> error = validator.validateEv(ev);
        if(error.isEmpty()){
            movie.setEv(ev);
            movieRepository.saveAndFlush(movie);
        }
        return ev;
    }

}
