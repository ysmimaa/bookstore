package service;

import entity.Book;
import repository.BookRepo;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookRepo bookRepo;

    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public Book createBook(Book book) {
        return bookRepo.create(book);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepo.read();
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepo.update(book);
    }

    @Override
    public Book deleteBook(Book book) {
        return bookRepo.delete(book);
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepo.find(id);
    }
}
