package year2015.day1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class Day1Test {

    private static Day1 day1 = new Day1();

    @BeforeAll
    static void setUp() {
    }

    @Test
    void part1Example() {
        InputStream is = new ByteArrayInputStream("))(((((".getBytes());
        day1.fileRead(is);
        assertEquals(3, day1.part1());
    }

    @Test
    void part1() {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("year2015/day1/input.txt");
        day1.fileRead(is);
        assertEquals(232, day1.part1());
    }

    @Test
    void part2Example() {
        InputStream is = new ByteArrayInputStream("((())())))".getBytes());
        day1.fileRead(is);
        assertEquals(9, day1.part2());
    }

    @Test
    void part2() {
        //InputStream is = Day1Test.class.getResourceAsStream("input.txt");
        InputStream is = this.getClass().getResourceAsStream("year2015/day1/input.txt");

        day1.fileRead(is);
        assertEquals(1783, day1.part2());
    }
}