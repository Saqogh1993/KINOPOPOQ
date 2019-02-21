package am.aca.kinopopoq.util.parserPackage;

import am.aca.kinopopoq.repository.entity.*;
import com.fasterxml.classmate.AnnotationConfiguration;
import com.thedeanda.lorem.LoremIpsum;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CsvParser {
    private static SessionFactory sessionFactory;
    public static void main(String[] args) {
        Set<Movie> parser = parser();
        Configuration conf = new Configuration()
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Director.class)
                .addAnnotatedClass(Genre.class)
                .addAnnotatedClass(Language.class)
                .addAnnotatedClass(Movie.class).configure();

                conf.buildSessionFactory()
                        .getCurrentSession()
                        .save(parser);
    }

    public static Set<Movie> parser() {

        String csvFile = "C:\\Users\\ANI\\Desktop\\ACA_JAVA\\imdb-5000-movie-dataset\\origin.csv";
        BufferedReader br = null;
        String line;
        LoremIpsum loremIpsum = new LoremIpsum();
        Set<Movie> mv = new HashSet<>();

        try {
            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {
//                line = line.replaceAll("[^\\x0A\\x0D\\x20-\\x7E]", "");

                String[] c = line.split(",");
                String[] genreSplit = c[2].split(":");
                Set<Actor> ac = new HashSet<>();
                Set<Genre> gn = new HashSet<>();
                ac.add(new Actor(String.valueOf(c[3])));
                ac.add(new Actor(String.valueOf(c[4])));
                ac.add(new Actor(String.valueOf(c[5])));
                Movie movieInstance = new Movie();

//                for (String s : genreSplit) {
//                    gn.add(new Genre(s));
//                }

                movieInstance.setMvId((long)c[0].hashCode());
                movieInstance.setTitle(c[0]);
                movieInstance.setDirector(new Director(c[1]));
                movieInstance.setActors(ac);
                movieInstance.setGenres(gn);
                movieInstance.setYear(Integer.parseInt(c[6]));
                movieInstance.setDuration(Integer.parseInt(c[9]));
                movieInstance.setBudget(c[10]);
                movieInstance.setDescription(loremIpsum.getWords(20));
//                movieInstance.setCountry(new Country(c[8]));
//                movieInstance.setLanguage(new Language(c[7]));
                movieInstance.setRating(c[11]);
                movieInstance.setPg(c[12]);
                movieInstance.setMovieLink(c[13]);

                mv.add(movieInstance);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return mv;
    }

}


