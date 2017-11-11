package hu.stib97.bookingApp.repository;

import hu.stib97.bookingApp.model.Lending;
import hu.stib97.bookingApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByName(String name);

    User findByPassword(String pw);

    List<User> findByFriends(User user);

    List<Lending> findByLendings(User user);


}
