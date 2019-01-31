package am.aca.imdb.parserPackage;

import am.aca.imdb.entity.*;
import com.thedeanda.lorem.LoremIpsum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CsvParser {

    public static List<Movie> parser() {

        String csvFile = "/Users/sargisghazaryan/Desktop/origin_second.csv";
        BufferedReader br = null;
        String line;
        ArrayList<insertedDataType> act_mv = new ArrayList<>();
        LoremIpsum loremIpsum = new LoremIpsum();
        List<Movie> mv = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {
//                line = line.replaceAll("[^\\x0A\\x0D\\x20-\\x7E]", "");

                String[] c = line.split(",");
                String[] genreSplit = c[2].split(":");
                List<Actor> ac = new ArrayList<>();
                List<Genre> gn = new ArrayList<>();
                ac.add(new Actor(String.valueOf(c[3])));
                ac.add(new Actor(String.valueOf(c[4])));
                ac.add(new Actor(String.valueOf(c[5])));
                Movie movieInstance = new Movie();

                for (String s : genreSplit) {
                    gn.add(new Genre(s));
                }

                movieInstance.setMvId(c[0].hashCode());
                movieInstance.setTitle(c[0]);
                movieInstance.setDirectors(new Director(c[1]));
                movieInstance.setActors(ac);
                movieInstance.setGenres(gn);
                movieInstance.setYear(Integer.parseInt(c[6]));
                movieInstance.setDuration(Integer.parseInt(c[9]));
                movieInstance.setBudget(c[10]);
                movieInstance.setDescription(loremIpsum.getWords(20));
                movieInstance.setCountries(new Country(c[8]));
                movieInstance.setLanguages(new Language(c[7]));
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


