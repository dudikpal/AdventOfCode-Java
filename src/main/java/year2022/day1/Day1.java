package year2022.day1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Day1 {

    private List<String> words;

    public int part1() {

        int maxCalorie = 0;
        int calorioes = 0;

        for (String calorie : words) {
            if (calorie.equals("")) {
                if (maxCalorie < calorioes) {
                    maxCalorie = calorioes;
                }
                calorioes = 0;
                continue;
            }
            calorioes += Integer.parseInt(calorie);
        }

        return maxCalorie;
    }

    public void readWordsFromFile(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        words = new ArrayList<>();
        try {
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file, ", ioe);
        }
    }
}
