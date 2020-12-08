package config;

import entity.Book;
import entity.Category;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateConfig {
    private static SessionFactory sessionFactory;

    public static SessionFactory buildSessionFactory() {
        if (sessionFactory == null) {
            try {
                Properties properties = new Properties();
                properties.put(Environment.DRIVER, "org.postgresql.Driver");
                properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/bookstore");
                properties.put(Environment.USER, "postgres");
                properties.put(Environment.PASS, "postgres");
                properties.put(Environment.FORMAT_SQL, "true");
                properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
                properties.put(Environment.SHOW_SQL, "true");
                properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                properties.put(Environment.HBM2DDL_AUTO, "update");
                properties.put(Environment.POOL_SIZE, "5");

                return new Configuration()
                        .setProperties(properties)
                        .addAnnotatedClass(Book.class)
                        .addAnnotatedClass(Category.class)
                        .buildSessionFactory();

            } catch (Throwable ex) {
                System.err.println("build SessionFactory failed :" + ex);
                throw new ExceptionInInitializerError(ex);
            }
        } else {
            return sessionFactory;
        }
    }
}
