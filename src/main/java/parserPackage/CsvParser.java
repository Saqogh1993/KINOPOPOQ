package parserPackage;

import java.io.*;
import java.util.*;

public class CsvParser {

    public static List<insertedDataType> parser() {

        String csvFile = "C:\\Users\\ANI\\Desktop\\ACA_JAVA\\imdb-5000-movie-dataset\\final\\Actors.csv";
        String csvFile2 = "C:\\Users\\ANI\\Desktop\\ACA_JAVA\\imdb-5000-movie-dataset\\telij\\movie_.csv";
        BufferedReader br = null;
        String line;
        String cvsSplitBy = ",";
        List<insertedDataType> act_mv = new ArrayList();

        try {

            br = new BufferedReader(new FileReader(csvFile));
            FileOutputStream os = new FileOutputStream(csvFile2);
            PrintWriter w = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));

            while ((line = br.readLine()) != null) {

//                line = line.replaceAll("[^\\x0A\\x0D\\x20-\\x7E]", "");

                String[] cell = line.split(cvsSplitBy);
                StringBuilder str = new StringBuilder();
                str.append(cell[0]).append(",").append(cell[1]).append("\n");
                act_mv.add(new insertedDataType(cell[0],cell[1]));
                w.print(str);
            }
            w.flush();
            w.close();

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
        return act_mv;
    }

}


