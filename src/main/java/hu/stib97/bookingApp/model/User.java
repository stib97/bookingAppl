package hu.stib97.bookingApp.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name ="name", nullable = false)
    private String name;

   @Column(name = "email")
   private String emailAddress;

   @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   private List<Lending> lendings = new ArrayList<>();

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "friends")
    private List<User> friends = new ArrayList<>();

    public User(String name, String emailAddress, String password) {
        this.name = name;
        this.emailAddress = emailAddress;
        lendings = new ArrayList<>();
        this.password = password;
        friends = new ArrayList<>();
    }

    public User(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<Lending> getLendings() {
        return lendings;
    }

    public void setLendings(List<Lending> lendings) {
        this.lendings = lendings;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password=" + password +
                '}';
    }
}
