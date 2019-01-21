package dao;

import am.aca.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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

    public static List<Movie> findMovieByName() {
        return session.createQuery("from Movie s where s.title = 'Korupcia'").getResultList();
    }

    public static List<Movie> findMovieByActorName() {
        String actorName = "Gor Vardanyan";

        Session session = sessionFactory.openSession();

        Query<Movie> query = session.createQuery("select m from Movie m join m.actors a where a.actName=:actorName", Movie.class);
        query.setParameter("actorName", actorName);
        List<Movie> movies = query.getResultList();

        session.close();

        return movies;
    }
}
