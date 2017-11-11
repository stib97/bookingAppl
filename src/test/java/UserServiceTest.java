import hu.stib97.bookingApp.model.Lending;
import hu.stib97.bookingApp.model.Movie;
import hu.stib97.bookingApp.model.User;
import hu.stib97.bookingApp.repository.UserRepository;
import hu.stib97.bookingApp.service.UserServiceImpl;
import hu.stib97.bookingApp.service.UserValidatorImpl;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UserServiceTest {

    public UserServiceImpl service;
    public UserRepository repo;
    public UserValidatorImpl validator;


    @Before
    public void setUp() throws Exception {
        validator = new UserValidatorImpl();
        service = new UserServiceImpl();
    }


    @Test(expected = RuntimeException.class)
    public void testAddUser() throws Exception {
        User testUser = new User("Minta","sjsj@sjsjs", "jelszo");
       service.addNewUser(testUser);
       User controll = repo.findByPassword("jelszo");
       assertEquals(testUser, controll);
    }

    @Test(expected = RuntimeException.class)
    public void testAddFriend() throws Exception {
        User testUser = new User("Minta","sjsj@sjsjs", "jelszo");
        User testUser2 = new User("Kis","sjsj@sjsjs", "jelszo2");
        service.addFriend(testUser, testUser2);
        List<User> test = new ArrayList<>();
        test.add(testUser2);
        assertEquals(test,service.getUserFriendsList(testUser));
    }

    @Test(expected = RuntimeException.class)
    public void testAddLending() throws Exception {
        User testUser = new User("Minta","sjsj@sjsjs", "jelszo");
        Movie movie = new Movie("Title", 1980);
        Lending lend = new Lending(new Date(), testUser, movie);
        service.addLending(testUser, lend);
        List<Lending> test = new ArrayList<>();
        test.add(lend);
        assertEquals(testUser.getLendings(),test);
    }

    @Test(expected = RuntimeException.class)
    public void testremoveFriend() throws Exception {
        User testUser = new User("Minta","sjsj@sjsjs", "jelszo");
        User testUser2 = new User("Kis","sjsj@sjsjs", "jelszo2");
        User testUser3 = new User("Nagy","sjsj@sjsjs", "jelszo2");
        service.addFriend(testUser, testUser2);
        service.addFriend(testUser, testUser3);
        service.removeFriend(testUser,testUser2);
        List<User> test = new ArrayList<>();
        test.add(testUser3);

        assertEquals(test,testUser.getFriends());
    }

    @Test(expected = RuntimeException.class)
    public void testRemoveLending() throws Exception {
        User testUser = new User("Minta","sjsj@sjsjs", "jelszo");
        Movie movie = new Movie("Title", 1980);
        Lending lend = new Lending(new Date(), testUser, movie);
        service.addLending(testUser, lend);
        service.removeLending(testUser, lend);
        List<Lending> test = new ArrayList<>();
        assertEquals(testUser.getLendings(),test);
    }

    @Test(expected = RuntimeException.class)
    public void testEditPassword() throws Exception {
        User testUser = new User("Minta","sjsj@sjsjs", "jelszo");
        service.editPassword(testUser, "mas");
        assertEquals("mas",testUser.getPassword());
    }

    @Test(expected = RuntimeException.class)
    public void testEditName() throws Exception {
        User testUser = new User("Minta","sjsj@sjsjs", "jelszo");
        service.editName(testUser, "Kis");
        assertEquals("Kis",testUser.getName());
    }

    @Test(expected = RuntimeException.class)
    public void testEmail() throws Exception {
        User testUser = new User("Minta","sjsj@sjsjs", "jelszo");
        service.editEmail(testUser, "minta@minta");
        assertEquals("minta@minta",testUser.getEmailAddress());
    }

    @Test(expected = RuntimeException.class)
    public void testEmailValidator() throws Exception {
        User testUser = new User("Minta","sjsj@sjsjs", "jelszo");
        service.editEmail(testUser, "");
        assertNotEquals("minta@minta",testUser.getEmailAddress());
    }

    @Test(expected = RuntimeException.class)
    public void testNameValidator() throws Exception {
        User testUser = new User("Minta","sjsj@sjsjs", "jelszo");
        service.editName(testUser, "");
        assertEquals("Minta",testUser.getName());
    }

    @Test(expected = RuntimeException.class)
    public void testPasswordValidator() throws Exception {
        User testUser = new User("Minta","sjsj@sjsjs", "jelszo");
        service.editPassword(testUser, null);
        assertEquals("jelszo",testUser.getName());
    }

    @Test(expected = RuntimeException.class)
    public void testgetUserList() throws Exception {
        User testUser = new User("Minta","sjsj@sjsjs", "jelszo");
        User testUser2 = new User("Kis","sjsj@sjsjs", "jelszo2");
        User testUser3 = new User("Nagy","sjsj@sjsjs", "jelszo2");
        service.addNewUser(testUser);
        service.addNewUser(testUser2);
        service.addNewUser(testUser3);
        List<User> test = new ArrayList<>();
        test.add(testUser);
        test.add(testUser2);
        test.add(testUser3);

        assertEquals(test, service.getUserList());
    }

    @Test(expected = RuntimeException.class)
    public void testisFriend() throws Exception {
        User testUser = new User("Minta","sjsj@sjsjs", "jelszo");
        User testUser2 = new User("Kis","sjsj@sjsjs", "jelszo2");
        service.addFriend(testUser, testUser2);
        assertEquals(service.isFriend(testUser,testUser2),true);
    }








}
