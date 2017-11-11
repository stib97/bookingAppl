import hu.stib97.bookingApp.model.Lending;
import hu.stib97.bookingApp.model.Movie;
import hu.stib97.bookingApp.model.User;
import hu.stib97.bookingApp.repository.LendingRepository;
import hu.stib97.bookingApp.service.LendingServiceImpl;
import hu.stib97.bookingApp.service.LendingValidatorImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LendingServiceTest {

    public LendingServiceImpl service;
    public LendingRepository repo;
    public LendingValidatorImpl validator;

    @Before
    public void setUp() throws Exception {
        validator = new LendingValidatorImpl();
        service = new LendingServiceImpl();
    }

    @Test(expected = RuntimeException.class)
    public void testcreateLending() throws Exception {
        User testUser = new User("Minta","sjsj@sjsjs", "jelszo");
        Movie movie = new Movie("Title", 1900);
        Lending lend = new Lending(new Date(), testUser, movie);
        service.createLending(lend);
        Lending controll = repo.findAll().get(0);
        assertEquals(lend, controll);
    }

    @Test(expected = RuntimeException.class)
    public void testdeleteLending() throws Exception {
        User testUser = new User("Minta","sjsj@sjsjs", "jelszo");
        Movie movie = new Movie("Title", 1900);
        Lending lend = new Lending(new Date(), testUser, movie);
        service.createLending(lend);
        service.deleteLending(lend);
        Lending controll = repo.findAll().get(0);
        assertEquals(null, controll);
    }

    @Test(expected = RuntimeException.class)
    public void testMovieByUser() throws Exception {
        User testUser = new User("Minta","sjsj@sjsjs", "jelszo");
        Movie movie = new Movie("Title", 1900);
        Lending lend = new Lending(new Date(), testUser, movie);
        service.getMovieByUser(testUser);
        assertEquals(movie, service.getMovieByUser(testUser));
    }

}
