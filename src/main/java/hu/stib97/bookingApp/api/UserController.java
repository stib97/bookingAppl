package hu.stib97.bookingApp.api;

import hu.stib97.bookingApp.model.Lending;
import hu.stib97.bookingApp.model.User;
import hu.stib97.bookingApp.repository.UserRepository;
import hu.stib97.bookingApp.security.Role;
import hu.stib97.bookingApp.security.UserRole;
import hu.stib97.bookingApp.service.interfaces.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

import static hu.stib97.bookingApp.security.UserRole.ADMIN;
import static hu.stib97.bookingApp.security.UserRole.USER;


@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserServiceI userService;

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin(origins = "http://localhost:4200")

    @Role(ADMIN)
    @PutMapping("add")
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        userService.addNewUser(user);

        return ResponseEntity.ok(user);
    }

    @Role({ADMIN,USER})
    @PostMapping("login/{username}/{password}")

    
    public ResponseEntity<User> login(@RequestParam String username, @RequestParam String password) {
        Optional<User> login = userService.login(username, password);

        if (login.isPresent()) {
            return ResponseEntity.ok(login.get());
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @Role({ADMIN,USER})
    @PostMapping("addFriend/{id}")
    public ResponseEntity<User> addFriend(@RequestParam Long id, @RequestBody User friend) {
        User user = userRepository.findOne(id);

        userService.addFriend(user, friend);

        return ResponseEntity.ok(user);
    }

    @Role({ADMIN,USER})
    @PostMapping("addLending/{id}")
    public ResponseEntity<User> addLending(@RequestParam Long id, @RequestBody Lending lend) {
        User user = userRepository.findOne(id);

        userService.addLending(user, lend);

        return ResponseEntity.ok(user);
    }

    @Role({ADMIN,USER})
    @PostMapping("removeFriend/{id}")
    public ResponseEntity<User> removeFriend(@RequestParam Long id, @RequestBody User friend) {
        User user = userRepository.findOne(id);

        userService.removeFriend(user, friend);

        return ResponseEntity.ok(user);
    }

    @Role({ADMIN,USER})
    @PostMapping("removeLending/{id}")
    public ResponseEntity<User> removeLending(@RequestParam Long id, @RequestBody Lending lend) {
        User user = userRepository.findOne(id);

        userService.removeLending(user, lend);

        return ResponseEntity.ok(user);
    }

    @Role({ADMIN,USER})
    @PostMapping("editPassword/{password}")
    public ResponseEntity<User> editPassword(@RequestBody User user, @RequestParam String password) {
        userService.editPassword(user, password);

        return ResponseEntity.ok(user);
    }

    @Role({ADMIN, USER})
    @PostMapping("editName/{name}")
    public ResponseEntity<User> editName(@RequestBody User user, @RequestParam String name) {
        userService.editName(user, name);

        return ResponseEntity.ok(user);
    }

    @Role({ADMIN,USER})
    @PostMapping("editEmail/{email}")
    public ResponseEntity<User> editEmail(@RequestBody User user, @RequestParam String email) {
        userService.editEmail(user, email);

        return ResponseEntity.ok(user);
    }

    @Role(ADMIN)
    @GetMapping("list")
    ResponseEntity<List<User>> getUserList() {
        List<User> userList = userService.getUserList();

        return ResponseEntity.ok(userList);
    }

    @Role({ADMIN,USER})
    @PostMapping("listFriends")
    ResponseEntity<List<User>> getUserFriendsList(@RequestBody User user) {
        List<User> userFriendsList = userService.getUserFriendsList(user);

        return ResponseEntity.ok(userFriendsList);
    }

    @Role({USER,ADMIN})
    @PostMapping("listLendigs")
    ResponseEntity<List<Lending>> getUserLendingList(@RequestBody User user) {
        List<Lending> userLendingList = userService.getUserLendingList(user);

        return ResponseEntity.ok(userLendingList);
    }

    @Role(ADMIN)
    @GetMapping("existBy/{name}")
    ResponseEntity<User> isUserExistsByName(@RequestParam String name) {
        User exists = userService.isUserExistsByName(name);

        return ResponseEntity.ok(exists);
    }

    @Role(ADMIN)
    @PostMapping("isFriend/{id}")
    ResponseEntity<Boolean> isFriend(@RequestParam Long id, @RequestBody User friend) {
        User one = userRepository.findOne(id);

        boolean isFriend = userService.isFriend(one, friend);

        return ResponseEntity.ok(isFriend);
    }
}
