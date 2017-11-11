package hu.stib97.bookingApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Cim")
    private String cim;

    @Column(name = "ev")
    private Integer ev;

    public Movie(String cim, int ev) {
        this.cim = cim;
        this.ev = ev;
    }

    public Movie(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public Integer getEv() {
        return ev;
    }

    public void setEv(Integer ev) {
        this.ev = ev;
    }

    @Override
    public String toString() {
        return cim.toString();
    }

}
