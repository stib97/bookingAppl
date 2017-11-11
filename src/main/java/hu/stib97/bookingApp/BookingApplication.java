package hu.stib97.bookingApp;

import hu.stib97.bookingApp.model.Book;
import hu.stib97.bookingApp.model.Lending;
import hu.stib97.bookingApp.model.Movie;
import hu.stib97.bookingApp.model.User;
import hu.stib97.bookingApp.repository.BookRepository;
import hu.stib97.bookingApp.repository.LendingRepository;
import hu.stib97.bookingApp.repository.MovieRepository;
import hu.stib97.bookingApp.repository.UserRepository;
import hu.stib97.bookingApp.service.BookServiceImpl;
import hu.stib97.bookingApp.service.LendingServiceImpl;
import hu.stib97.bookingApp.service.MovieServiceImpl;
import hu.stib97.bookingApp.service.UserServiceImpl;
import hu.stib97.bookingApp.service.interfaces.UserServiceI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Collections;
import java.util.Date;

/**
 * Created by Steinerbrunner Ibolya on 2017.07.06..
 */
@SpringBootApplication
@EnableJpaRepositories
public class BookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingApplication.class, args);

//        ConfigurableApplicationContext ctx = SpringApplication.run(BookingApplication.class, args);
//        UserServiceI userService = ctx.getBean(UserServiceImpl.class);
//        LendingServiceI lendService = ctx.getBean(LendingServiceImpl.class);
//        MovieServiceI movieService = ctx.getBean(MovieServiceImpl.class);
//        BookServiceI bookService = ctx.getBean(BookServiceImpl.class);

//        //User testuser = new User("Example", "teszt", "test");
//        //userService.addNewUser(testuser);
//        //userService.editEmail(testuser,"example");
//        User user = userService.isUserExistsByName("Example");
//        // userService.editEmail(user,"example@example");
//        Movie movie = new Movie("klkl", 2000);
//        movieService.createMovie(movie);
//
//        Lending lend = new Lending(new Date(), user, movie);
//        lendService.createLending(lend);
//        userService.addLending(user,lend);

    }

    @Bean
    public CommandLineRunner commandLineRunner(LendingServiceImpl lendingService,
                                               UserServiceImpl userService
            , BookServiceImpl bookService) {
        return args -> {
            User user = new User();
            user.setName("name");
            user.setEmailAddress("adsa");
            user.setPassword("asd");

            userService.addNewUser(user);

            Book book = new Book();
            book.setIro("ala");
            book.setCim("asd");

            bookService.createBook(book);

            Lending lending = new Lending();
            lending.setUser(user);
            lending.setBook(book);
            lending.setDate(new Date());

            lendingService.createLending(lending);

            Lending lending2 = new Lending();
            lending2.setUser(user);
            lending2.setBook(book);
            lending2.setDate(new Date());

            lendingService.createLending(lending2);

//            userService.removeLending(user,lending);

            bookService.editIro(book,"alamaasd");

            userService.editName(user,"sasadsada");

            bookService.delete(book);
        };
    }
}


