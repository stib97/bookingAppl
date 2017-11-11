package hu.stib97.bookingApp.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Lending")
public class Lending {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    private User user;

    @OneToOne
    private Movie movie;

    @OneToOne
    private Book book;

    public Lending(Date date, User user, Movie movie) {
        this.date = date;
        this.user = user;
        this.movie = movie;
    }

    public Lending(Date date, User user, Book book) {
        this.date = date;
        this.user = user;
        this.book = book;
    }

    public Lending() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Kölcsönzés részletei:" +
                "\n\n" +
                "Kölcsönzés dátuma:" + date +
                "\n\n" +
                "Kölcsönzött film: " + movie +
                "\n\n" +
                "Kölcsönzött könyv " + book +
                "\n\n";
    }

}