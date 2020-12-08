package repository;

import entity.Book;

import java.util.List;

public interface BookRepo {

    Book create(Book book);

    List<Book> read();

    Book update(Book book);

    Book delete(Book book);

    Book find(Long id);
}
