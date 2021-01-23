package year2015.day2;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

class Day2Test {

    private Day2 day2 = new Day2();

    @Test
    void part1Example() {
        String dimensions = "2x3x4";

        day2.fileRead(new BufferedReader(new StringReader(dimensions)));
        assertEquals(58, day2.part1());
    }

    @Test
    void part1() {
        InputStream is = Day2Test.class.getResourceAsStream("input.txt");
        day2.fileRead(new BufferedReader(new InputStreamReader(is)));
        assertEquals(1588178, day2.part1());
    }

    @Test
    void part2Example() {
        String dimensions = "2x3x4";

        day2.fileRead(new BufferedReader(new StringReader(dimensions)));
        assertEquals(34, day2.part2());
    }

    @Test
    void part2() {
        InputStream is = Day2.class.getResourceAsStream("input.txt");
        day2.fileRead(new BufferedReader(new InputStreamReader(is)));
        assertEquals(3783758, day2.part2());
    }

}