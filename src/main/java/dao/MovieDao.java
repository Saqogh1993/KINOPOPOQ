package dao;

import am.aca.entities.*;
import org.hibernate.ReplicationMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import parserPackage.CsvParser;

import java.util.Set;

public class MovieDao {

    private static final SessionFactory sessionFactory = new Configuration()
            .configure()
            .addAnnotatedClass(Actor.class)
            .addAnnotatedClass(Movie.class)
            .addAnnotatedClass(Director.class)
            .addAnnotatedClass(Genre.class)
            .addAnnotatedClass(Language.class)
            .addAnnotatedClass(Country.class)
            .buildSessionFactory();

    private static final Session session = sessionFactory.openSession();

    public static void saveIn() {
        Set<Movie> actMvList = CsvParser.parser();
//        session.createNativeQuery("ALTER TABLE director DISABLE TRIGGER ALL").executeUpdate();
//        session.createNativeQuery("ALTER TABLE movie DISABLE TRIGGER ALL").executeUpdate();
        session.beginTransaction();

        for (Movie movie : actMvList) {
//            session.saveOrUpdate(movie);
//            session.saveOrUpdate(movie);
            session.replicate(movie, ReplicationMode.LATEST_VERSION);
            session.flush();
            session.clear();
        }
        session.getTransaction().commit();


        System.out.println(session.find(Movie.class, -1673652105).getTitle());


        Movie load = session.load(Movie.class, -1673652105);
        System.out.println(load.getTitle());
        System.out.println(load.getBudget());
        System.out.println(load.getLanguages().getLanguageName());
        System.out.println(load.getCountries().getCountryName());
        System.out.println(load.getDirectors().getName());
    }


}
