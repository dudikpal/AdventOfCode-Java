package year2015.day5;

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

class Day5Test {
    
    
    private static BufferedReader br;
    private static Day5 day5 = new Day5();
    
    
    @Test
    void part1ExampleNice() {
        String input = "ugknbfddgicrmopn";
        br = new BufferedReader(new StringReader(input));
        
        day5.readWordsFromFile(br);
        
        assertEquals(1, day5.part1());
    }
    
    
    @Test
    void part1ExampleNaughty() {
        String input = "haegwjzuvuyypxyu";
        br = new BufferedReader(new StringReader(input));
        
        day5.readWordsFromFile(br);
        
        assertEquals(0, day5.part1());
    }
    
    
    @Test
    void part1() {
        InputStream is = Day5.class.getResourceAsStream("input.txt");
        br = new BufferedReader(new InputStreamReader(is));
        
        day5.readWordsFromFile(br);
        
        assertEquals(236, day5.part1());
    }
    
    
    @Test
    void part2ExampleNice1() {
        String input = "qjhvhtzxzqqjkmpb";
        br = new BufferedReader(new StringReader(input));
        
        day5.readWordsFromFile(br);
        
        assertEquals(1, day5.part2());
    }
    
    
    @Test
    void part2ExampleNice2() {
        String input = "xxyxx";
        br = new BufferedReader(new StringReader(input));
        
        day5.readWordsFromFile(br);
        
        assertEquals(1, day5.part2());
    }
    
    
    @Test
    void part2ExampleNaughty1() {
        String input = "uurcxstgmygtbstg";
        br = new BufferedReader(new StringReader(input));
        
        day5.readWordsFromFile(br);
        
        assertEquals(0, day5.part2());
    }
    
    
    @Test
    void part2ExampleNaughty2() {
        String input = "ieodomkazucvgmuy";
        br = new BufferedReader(new StringReader(input));
        
        day5.readWordsFromFile(br);
        
        assertEquals(0, day5.part2());
    }
    
    
    @Test
    void part2() {
        InputStream is = Day5.class.getResourceAsStream("input.txt");
        br = new BufferedReader(new InputStreamReader(is));
        
        day5.readWordsFromFile(br);
        
        assertEquals(51, day5.part2());
    }
}