package year2022.day2;

import org.junit.jupiter.api.Test;
import utils.FileRead;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Day2Test {

    private Day2 day2 = new Day2();

    @Test
    void exampleTest() {
        String[] input = """
                A Y
                B X
                C Z""".split("\n");
        InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
        assertEquals(15, day2.part1(FileRead.readByLines(is)));
    }

    @Test
    void part1() {
        InputStream is = this.getClass().getResourceAsStream("input.txt");
        assertEquals(8392, day2.part1(FileRead.readByLines(is)));
    }

}