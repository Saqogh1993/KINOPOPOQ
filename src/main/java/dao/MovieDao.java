package dao;

import am.aca.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import parserPackage.CsvParser;
import parserPackage.insertedDataType;

import java.util.Iterator;
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

//    String nativeSql = "INSERT INTO public.actor_movie (movie_id, actor_id) " +
//            "VALUES (" + movieAndActor.getInsertedKey() + "," + movieAndActor.getInsertedValue() + ")";

    final static Session session = sessionFactory.openSession();


    public static void saveIn() {
        List actMvList = CsvParser.parser();
        session.beginTransaction();
        //ALTER TABLE reference DISABLE TRIGGER ALL;
//        session.createNativeQuery("ALTER TABLE actor_movie DISABLE TRIGGER ALL").executeUpdate();

        Iterator iter = actMvList.iterator();
        while (iter.hasNext()) {
            insertedDataType insertedDataType = (insertedDataType) iter.next();
            String nativeSql = "INSERT INTO public.actor (act_id, act_name) " +
                    "VALUES (" + insertedDataType.getInsertedKey() + "," + insertedDataType.getInsertedValue() + ")";
            NativeQuery nativeQuery = session.createNativeQuery(nativeSql);
            nativeQuery.executeUpdate();
        }

//        String nativeSql = "INSERT INTO public.actor (act_id, name) VALUES (" + i + ", 'u')";
//        NativeQuery nativeQuery = session.createNativeQuery(nativeSql);
//        nativeQuery.executeUpdate();
//        session.createNativeQuery("ALTER TABLE actor_movie ENABLE TRIGGER ALL");
        session.getTransaction().commit();
        session.close();
    }


//    public static List<Movie> findAllMovies() {
//        return session.createQuery("from Movie").getResultList();
//    }
}
