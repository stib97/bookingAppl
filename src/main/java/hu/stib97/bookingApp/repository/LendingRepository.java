package hu.stib97.bookingApp.repository;

import hu.stib97.bookingApp.model.Lending;
import hu.stib97.bookingApp.model.Movie;
import hu.stib97.bookingApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LendingRepository extends JpaRepository<Lending,Long> {

     List<Lending> findByUser(User user);


}
