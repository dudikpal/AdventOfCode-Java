package year2022.day1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Day1Test {

    private Day1 day1 = new Day1();

    @Test
    void part1ExampleTest() {
        String input = """
                1000
                2000
                3000
                                
                4000
                                
                5000
                6000
                                
                7000
                8000
                9000
                                
                10000""";

        String[] words = input.split("\n");
        InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(words)).getBytes(StandardCharsets.UTF_8));
        day1.readWordsFromFile(is);
        assertEquals(24000, day1.part1());
    }

    @Test
    void part1Test() {
        InputStream is = this.getClass().getResourceAsStream("input.txt");
        day1.readWordsFromFile(is);
        assertEquals(70296, day1.part1());
    }

    @Test
    void part2Test() {
        InputStream is = this.getClass().getResourceAsStream("input.txt");
        day1.readWordsFromFile(is);
        assertEquals(205381, day1.part2());
    }
}