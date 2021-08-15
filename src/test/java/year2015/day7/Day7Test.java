package year2015.day7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Day7Test {

    private Day7 day7;

    @BeforeEach
    void setUp() {
        day7 = new Day7();
    }
    
    @Test
    void part1Example() {
        
        String input = "123 -> x\n" +
                           "456 -> y\n" +
                           "x AND y -> d\n" +
                           "x OR y -> e\n" +
                           "x LSHIFT 2 -> f\n" +
                           "y RSHIFT 2 -> g\n" +
                           "NOT x -> h\n" +
                           "NOT y -> i";

        String resultWire = "h";
        BufferedReader br = new BufferedReader(new StringReader(input));
        day7.loadInputFromFile(br);

        assertEquals(65412, day7.part1(resultWire));
    }

    @Test
    void part1Test() {

        InputStream is = this.getClass().getResourceAsStream("input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        day7.loadInputFromFile(br);
        String resultWire = "a";

        assertEquals(956, day7.part1(resultWire));
    }

    @Test
    void part2Test() {

        InputStream is = this.getClass().getResourceAsStream("input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        day7.loadInputFromFile(br);
        String resultWire = "a";
        String wireToChange = "b";
        int newValue = 956;

        assertEquals(40149, day7.part2(resultWire, wireToChange, newValue));
    }
}