package parserPackage;

import am.aca.entities.*;
import com.thedeanda.lorem.LoremIpsum;

import java.io.*;
import java.util.*;

public class CsvParser {

    public static Set<Movie> parser() {

        String csvFile = "C:\\Users\\ANI\\Desktop\\ACA_JAVA\\imdb-5000-movie-dataset\\origin_second.csv";
        BufferedReader br = null;
        String line;
        ArrayList<insertedDataType> act_mv = new ArrayList<>();
        LoremIpsum loremIpsum = new LoremIpsum();
        Set<Movie> mv = new HashSet<>();

        try {
            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {
//                line = line.replaceAll("[^\\x0A\\x0D\\x20-\\x7E]", "");

                String[] c = line.split(",");
                String[] genreSplit = c[2].split(":");
                StringBuilder str = new StringBuilder();
                Set<Actor> ac = new HashSet<>();
                Set<Genre> gn = new HashSet<>();
                ac.add(new Actor(String.valueOf(c[3])));
                ac.add(new Actor(String.valueOf(c[4])));
                ac.add(new Actor(String.valueOf(c[5])));

                for (String s: genreSplit) {
                    gn.add(new Genre(s));
                }

                mv.add(new Movie(c[0],
                        new Director(c[1]),
                        Integer.parseInt(c[6]),
                        Integer.parseInt(c[9]),
                        c[10],
                        loremIpsum.getWords(20),
                        ac,
                        gn,
                        new Country(c[8]),
                        new Language(c[7])));
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


