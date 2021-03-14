package year2015.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day5 {
    
    private List<String> words;
    private final static String niceVowels = "aeiou";
    private final static String[] naughtyStrings = {"ab", "cd", "pq", "xy"};
    
    
    public int part1() {
        int counter = 0;
        for (String word : words) {
            if (doubleLetter(word) && countVowel(word) > 2 && !containNaughtyString(word, 0)) {
                counter++;
            }
        }
        return counter;
    }
    
    
    public int part2() {
        int counter = 0;
        for (String word : words) {
            if (doubleLetterTwice(word) && betweenDoubleLetter(word)) {
                counter++;
            }
        }
        return counter;
    }
    
    
    private boolean betweenDoubleLetter(String word) {
        if (word.length() < 3) {
            return false;
        }
        if (word.charAt(0) == word.charAt(2)) {
            return true;
        }
        return betweenDoubleLetter(word.substring(1));
    }
    
    
    private boolean doubleLetterTwice(String word) {
        if (word.length() < 4) {
            return false;
        }
        String startWord = word.substring(0, 2);
        String leftWord = word.substring(2);
        if (leftWord.contains(startWord)) {
            return true;
        }
        return doubleLetterTwice(word.substring(1));
    }
    
    
    private boolean containNaughtyString(String word, int index) {
        if (index == naughtyStrings.length) {
            return false;
        }
        if (!word.contains(naughtyStrings[index])) {
            return containNaughtyString(word, ++index);
        }
        return true;
    }
    
    
    private int countVowel(String word) {
        if (word.length() == 0) {
            return 0;
        }
        if (niceVowels.contains(String.valueOf(word.charAt(0)))) {
            return 1 + countVowel(word.substring(1));
        }
        return countVowel(word.substring(1));
    }
    
    
    private boolean doubleLetter(String word) {
        if (word.length() < 2) {
            return false;
        }
        if (word.charAt(0) == word.charAt(1)) {
            return true;
        }
        return doubleLetter(word.substring(1));
    }
    
    
    public void readWordsFromFile(BufferedReader reader) {
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
