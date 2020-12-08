package service;

import entity.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import repository.BookRepo;

import java.util.Arrays;
import java.util.List;

class BookServiceImplTest {

    @InjectMocks
    private BookService bookService=new BookServiceImpl(null);

    @Mock
    private BookRepo bookRepo;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createBook() {
        //Given
        Book book1 = Book.builder()
                .id(1L)
                .ISBN("ISBN")
                .build();

        //When
        Mockito.when(bookRepo.create(ArgumentMatchers.any(Book.class))).thenReturn(book1);
        Book createdBook = bookService.createBook(book1);

        //Then
        Assertions.assertAll("Satisfy the conditions below",
                () -> Assertions.assertEquals(book1.getId(), createdBook.getId()));
    }

    @Test
    void getBooks() {
        //Given
        List<Book> books = Arrays.asList(
                Book.builder()
                        .id(1L)
                        .ISBN("ISBN")
                        .build());

        //When
        Mockito.when(bookRepo.read()).thenReturn(books);
        List<Book> booksFound = bookService.getBooks();

        //Then
        Assertions.assertAll("Conditions to be executed",
                () -> Assertions.assertEquals(books.size(), booksFound.size()));

        Assertions.assertEquals(books.get(0).getId(), booksFound.get(0).getId());
    }

    @Test
    void updateBook() {
        //Given
        Book bookToUpdate = Book.builder()
                .id(1L)
                .ISBN("ISBN-01")
                .build();
        //When
        Mockito.when(bookRepo.update(ArgumentMatchers.any(Book.class))).thenReturn(bookToUpdate);
        Book updatedBook = bookService.updateBook(bookToUpdate);

        //Then
        Assertions.assertEquals(updatedBook.getISBN(),bookToUpdate.getISBN());
    }

    @Test
    void deleteBook() {
        //Given
        Book bookToDelete = Book.builder()
                .id(1L)
                .ISBN("ISBN-01")
                .build();

        //When
        Mockito.when(bookRepo.delete(ArgumentMatchers.any(Book.class))).thenReturn(bookToDelete);
        Book deletedBook = bookService.deleteBook(bookToDelete);

        //Then
        Assertions.assertEquals(deletedBook,bookToDelete);

    }
}