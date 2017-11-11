import hu.stib97.bookingApp.model.Movie;
import hu.stib97.bookingApp.model.User;
import hu.stib97.bookingApp.repository.LendingRepository;
import hu.stib97.bookingApp.repository.MovieRepository;
import hu.stib97.bookingApp.service.LendingServiceImpl;
import hu.stib97.bookingApp.service.LendingValidatorImpl;
import hu.stib97.bookingApp.service.MovieServiceImpl;
import hu.stib97.bookingApp.service.MovieValidatorImpl;
import hu.stib97.bookingApp.service.interfaces.MovieValidatorI;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MovieServiceTest {

    public MovieServiceImpl service;
    public MovieRepository repo;
    public MovieValidatorI validator;

    @Before
    public void setUp() throws Exception {
        validator = new MovieValidatorImpl();
        service = new MovieServiceImpl();
    }

    @Test(expected = RuntimeException.class)
    public void testEvValidator() throws Exception {
        Movie movie = new Movie("Title",1980);
        service.editEv(movie, 1800);
        assertEquals(java.util.Optional.of(1980),movie.getEv());
    }

    @Test(expected = RuntimeException.class)
    public void testCimValidator() throws Exception {
        Movie movie = new Movie("Title",1980);
        service.editTitle(movie, "");
        assertEquals(java.util.Optional.of("Title"),movie.getCim());
    }
}
