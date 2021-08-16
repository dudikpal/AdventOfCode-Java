package year2015.day8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

class Day8Test {

    Day8 day8;

    @BeforeEach
    void setUp() {
        day8 = new Day8();
    }

    @Test
    void part1Test() {

        InputStream is = this.getClass().getResourceAsStream("input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        day8.loadDatasFromFile(br);

        int expected = 1371;
        assertEquals(expected, day8.part1());
    }

    @Test
    void part2Test() {

        InputStream is = this.getClass().getResourceAsStream("input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        day8.loadDatasFromFile(br);

        int expected = 2117;
        assertEquals(expected, day8.part2());
    }

}