package hu.stib97.bookingApp.service.interfaces;

import hu.stib97.bookingApp.model.Lending;
import hu.stib97.bookingApp.model.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceI {

    void addNewUser(User user);

    Optional<User> login(String username, String password);

    void addFriend(User user, User friend);

    void removeFriend(User user, User friend);

    void removeLending(User user, Lending lend);

    String editPassword(User user, String newPassword);

    String editName(User user, String newName);

    String editEmail(User user, String newEmail);

    List<User> getUserList();

    List<User> getUserFriendsList(User user);

    List<Lending> getUserLendingList(User user);

    User isUserExistsByName(String name);

    boolean isFriend(User user, User friend);

    void addLending(User user, Lending lend);


    User getUser();
}
