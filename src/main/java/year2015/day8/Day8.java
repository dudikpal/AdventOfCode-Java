package year2015.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Day8 {

    private List<String> lines = new ArrayList<>();

    private int charsInCode = 0, charsInMemory = 0;


    public int part1() {

        String regex = "(\\\\x[a-f0-9]{2})|\\\\\\\\|\\\\\"";

        for (String line : lines) {

            charsInCode += line.length();
            line = line.replaceAll(regex, "Y").replaceAll("\"", "");
            charsInMemory += line.length();
        }

        return charsInCode - charsInMemory;
    }


    public int part2() {

        for (String line : lines) {

            charsInMemory += line.length();

            line = line.replaceAll("\\\\", "\\\\\\\\")
            .replaceAll("\"", "\\\\\"");

            line = line + "YY";
            charsInCode += line.length();
        }

        return charsInCode - charsInMemory;
    }


    public void loadDatasFromFile(BufferedReader br) {

        try {
            String line;

            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file, ", ioe);
        }
    }

}
