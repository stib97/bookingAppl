package hu.stib97.bookingApp.service.interfaces;

import hu.stib97.bookingApp.model.Book;

import java.util.List;

public interface BookServiceI {

    String editIro(Book book, String newIro);

    String editTitle(Book book, String newTitle);

    void delete(Book book);

    void createBook(Book book);

    List<Book> getBooks();
}
