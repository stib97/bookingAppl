package hu.stib97.bookingApp.service;

import hu.stib97.bookingApp.model.Lending;
import hu.stib97.bookingApp.model.User;
import hu.stib97.bookingApp.repository.UserRepository;
import hu.stib97.bookingApp.service.interfaces.UserServiceI;
import hu.stib97.bookingApp.service.interfaces.UserValidatorI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserValidatorI validator;


    @Override
    public Optional<User> login(String username, String password) {
        Optional<User> optionalUser = userRepository.findByName(username);
        return optionalUser.filter(user -> user.getPassword().equals(password));
    }

    @Override
    public void addNewUser(User user) {
        List<String> errors = validator.validate(user);
        if (errors.isEmpty()) {
            userRepository.save(user);
        }
    }

    @Override
    public void addFriend(User user, User friend){
        ArrayList<User> friendsNew = new ArrayList<>(user.getFriends());
        if(!friendsNew.contains(friend)){
            friendsNew.add(friend);
            user.setFriends(friendsNew);
            userRepository.saveAndFlush(user);
        }
    }

    @Override
    public void addLending(User user, Lending lend){
        ArrayList<Lending> lendings = new ArrayList<>(user.getLendings());
        if(!lendings.contains(lend)){
            lendings.add(lend);
            user.setLendings(lendings);
            userRepository.save(user);
        }
    }

    @Override
    public void removeFriend(User user, User friend){
        user.getFriends().remove(friend);
        userRepository.saveAndFlush(user);
    }

    @Override
    public void removeLending(User user, Lending lend){
        user.getLendings().remove(lend);
        userRepository.saveAndFlush(user);
    }

    @Override
    public String editPassword(User user, String newPassword){
        List<String> error = validator.validatePassword(newPassword);
        if(error.isEmpty()) {
            user.setPassword(newPassword);
            userRepository.saveAndFlush(user);
        }
        return newPassword;
    }

    @Override
    public String editName(User user, String newName){
        List<String> error = validator.validateName(newName);
        if(error.isEmpty()){
            user.setName(newName);
            userRepository.saveAndFlush(user);
        }
        return newName;
    }

    @Override
    public String editEmail(User user, String newEmail){
        List<String> error = validator.validateEmail(newEmail);
        if(error.isEmpty()){
            user.setEmailAddress(newEmail);
            userRepository.saveAndFlush(user);
        }
        return newEmail;
    }

    @Override
    public List<User> getUserList(){
        return userRepository.findAll();
    }

    @Override
    public List<User> getUserFriendsList(User user){
        return userRepository.findByFriends(user);
    }

    @Override
    public List<Lending> getUserLendingList(User user){ return userRepository.findByLendings(user);}

    @Override
    public User isUserExistsByName(String name){
        User ret = null;
        for(User user : userRepository.findAll()){
            if(user.getName().equals(name)){
                ret = user;
            }
        }
        return ret;
    }

    @Override
    public boolean isFriend(User user, User friend){
        boolean ret = false;
        ArrayList<User> friends = new ArrayList<>(user.getFriends());
        for(User us : friends){
            if(us.getId().equals(friend.getId())){
                ret = true;
            }
        }
        return ret;
    }









}