package hu.stib97.bookingApp.service;

import hu.stib97.bookingApp.model.Book;
import hu.stib97.bookingApp.model.Lending;
import hu.stib97.bookingApp.repository.BookRepository;
import hu.stib97.bookingApp.repository.LendingRepository;
import hu.stib97.bookingApp.service.interfaces.BookServiceI;
import hu.stib97.bookingApp.service.interfaces.BookValidatorI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookServiceI {

    @Autowired
    public BookRepository bookRepository;

    @Autowired
    public LendingRepository lendingRepository;

    @Autowired
    public BookValidatorI validator;

    @Override
    public void createBook(Book book){
        List<String> errors = validator.validate(book);
        if(errors.isEmpty()){
            bookRepository.save(book);
        }
        else{
            System.out.println("Hiba van valamelyik adattagban!");
        }
    }

    @Override
    public void delete(Book book){
        boolean kivan = false;
        for(Lending lend : lendingRepository.findAll()){
            if(lend.getBook().equals(book)) {
                kivan = true;
                System.out.println("ki van kölcsönözve, nem törölhető!");
            }
        }
        if(kivan = false){
            bookRepository.delete(book.getId());
        }
    }

    @Override
    public String editTitle(Book book, String newTitle){
        List<String> error = validator.validateTitle(newTitle);
        if(error.isEmpty()){
            book.setCim(newTitle);
            bookRepository.saveAndFlush(book);
        }
        return newTitle;
    }

    @Override
    public String editIro(Book book, String newIro){
        List<String> error = validator.validateIro(newIro);
        if(error.isEmpty()){
            book.setIro(newIro);
            bookRepository.saveAndFlush(book);
        }
        return newIro;
    }

    @Override
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

}
