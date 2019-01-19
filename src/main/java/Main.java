import static dao.MovieDao.saveIn;

public class Main {

    public static void main(String... args) {
//        SessionFactory sessionFactory = new Configuration()
//                .configure()
//                .addAnnotatedClass(Actor.class)
//                .addAnnotatedClass(Movie.class)
//                .addAnnotatedClass(Director.class)
//                .addAnnotatedClass(Genre.class)
//                .addAnnotatedClass(Language.class)
//                .addAnnotatedClass(Country.class)
//                .buildSessionFactory();


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

        saveIn();
//        System.out.println(MovieDao.findAllMovies());

    }
}