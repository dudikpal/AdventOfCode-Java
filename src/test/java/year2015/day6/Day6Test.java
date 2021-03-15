package year2015.day6;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

class Day6Test {
    
    
    @Test
    void testPart1Example() {
        String input = "turn on 0,0 through 999,999\n" +
                              "toggle 0,0 through 999,0\n" +
                              "turn off 499,499 through 500,500";
        
        BufferedReader br = new BufferedReader(new StringReader(input));
        Day6 day6 = new Day6();
        day6.readWordsFromFile(br);
        
        assertEquals(998996, day6.part1());
    }
    
    
    @Test
    void testPart1() {
        InputStream is = this.getClass().getResourceAsStream("input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        
        Day6 day6 = new Day6();
        
        day6.readWordsFromFile(br);
        
        
        assertEquals(569999, day6.part1());
    }
    
    
    @Test
    void testPart2Example() {
        String input = "turn on 0,0 through 999,999\n" +
                           "toggle 0,0 through 999,0\n" +
                           "turn off 499,499 through 500,500";
        
        BufferedReader br = new BufferedReader(new StringReader(input));
        Day6 day6 = new Day6();
        day6.readWordsFromFile(br);
        
        assertEquals(1001996, day6.part2());
    }
    
    
    @Test
    void testPart2() {
        InputStream is = this.getClass().getResourceAsStream("input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        
        Day6 day6 = new Day6();
        
        day6.readWordsFromFile(br);
        
        
        assertEquals(17836115, day6.part2());
    }
    
}