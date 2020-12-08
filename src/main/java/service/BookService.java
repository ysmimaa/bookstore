package service;

import entity.Book;

import java.util.List;

public interface BookService {

    Book createBook(Book book);

    List<Book> getBooks();

    Book updateBook(Book book);

    Book deleteBook(Book book);

    Book findBookById(Long id);
}
