package year2022.day1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Day1 {

    private List<String> words;
    List<Integer> calories = new ArrayList<>();

    public int part1() {

        Collections.sort(calories);
        Collections.reverse(calories);

        return calories.get(0);
    }

    public int part2() {

        Collections.sort(calories);
        Collections.reverse(calories);

        return calories.get(0) + calories.get(1) + calories.get(2);
    }

    private void fillCalories() {

        int calorioes = 0;

        for (String calorie : words) {

            if (calorie.equals("")) {
                calories.add(calorioes);
                calorioes = 0;
                continue;
            }
            calorioes += Integer.parseInt(calorie);
        }
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
        fillCalories();
    }
}
