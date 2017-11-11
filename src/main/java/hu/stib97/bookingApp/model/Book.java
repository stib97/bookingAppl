package hu.stib97.bookingApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Steinerbrunner Ibolya on 2017.07.10..
 */

@Entity
@Table(name = "Book")
public class Book {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "Id")
        private Long id;

        @Column(name = "Cim")
        private String cim;

        @Column(name = "iro")
        private String iro;

        public Book(String cim, String iro) {
                this.cim = cim;
                this.iro = iro;
        }

        public Book() {
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

        public String getIro() {
                return iro;
        }

        public void setIro(String iro) {
                this.iro = iro;
        }
}