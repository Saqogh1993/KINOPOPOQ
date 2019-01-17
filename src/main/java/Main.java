import am.aca.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.GeneratedValue;
import java.util.List;

public class Main {

    public static void main(String... args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Movie.class)
                .addAnnotatedClass(Director.class)
                .addAnnotatedClass(Genre.class)
                .addAnnotatedClass(Language.class)
                .addAnnotatedClass(Country.class)
                .buildSessionFactory();


//        Integer actorId = 1;
//
//        Session session = sessionFactory.openSession();
//
//        Query<Movie> query = session.createQuery("select m from Movie m join m.actors a where a.id=:actorId", Movie.class);
//        query.setParameter("actorId", actorId);
//        List<Movie> movies = query.getResultList();
//
//        System.out.println(movies);
//
//        session.close();

    }
}