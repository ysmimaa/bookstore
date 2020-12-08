package repository;

import config.HibernateConfig;
import entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BookRepoImpl implements BookRepo {

    private SessionFactory sessionFactory;

    public BookRepoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Book create(Book book) {
        if (book != null) {
            Session session = sessionFactory.openSession();
            Transaction tx = session.getTransaction();
            tx.begin();
            session.save(book);
            tx.commit();
            return book;
        }
        return null;
    }

    @Override
    public List<Book> read() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Query<Book> book = session.createQuery("from Book", Book.class);
        List<Book> resultList = book.getResultList();
        transaction.commit();
        return resultList;
    }

    @Override
    public Book update(Book book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Book bookFound;
        if (book != null && book.getId() != null) {
            bookFound = session.load(Book.class, book.getId());
            if (bookFound != null) {
                bookFound.setISBN(book.getISBN());
            }
        }
        transaction.commit();
        return book;
    }

    @Override
    public Book delete(Book book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        if (book != null) {
            transaction.begin();
            Book foundBook = session.load(Book.class, book.getId());
            if (foundBook != null) {
                session.remove(foundBook);
                transaction.commit();
                return book;
            }
        }

        return null;
    }

    @Override
    public Book find(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        if (id != null) {
            transaction.begin();
            Book foundBook = session.get(Book.class, id);
            transaction.commit();
            if (foundBook != null) {
                return foundBook;
            }
        }
        return null;
    }

}
