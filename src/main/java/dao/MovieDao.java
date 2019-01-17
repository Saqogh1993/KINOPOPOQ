package dao;

import am.aca.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MovieDao {

    final static SessionFactory sessionFactory = new Configuration()
            .configure()
            .addAnnotatedClass(Actor.class)
            .addAnnotatedClass(Movie.class)
            .addAnnotatedClass(Director.class)
            .addAnnotatedClass(Genre.class)
            .addAnnotatedClass(Language.class)
            .addAnnotatedClass(Country.class)
            .buildSessionFactory();

    final static Session session = sessionFactory.openSession();


    public static List<Movie> findAllMovies() {
        return session.createQuery("from Movie").getResultList();
    }
}
