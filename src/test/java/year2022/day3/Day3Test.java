package year2022.day3;

import org.junit.jupiter.api.Test;
import utils.FileRead;
import year2022.day2.Day2;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Day3Test {

    private Day3 day3 = new Day3();

    @Test
    void exampleTest() {
        String[] input = """
               vJrwpWtwJgWrhcsFMMfFFhFp
               jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
               PmmdzqPrVvPwwTWBwg
               wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
               ttgJtRGJQctTZtZT
               CrZsJsPPZsGzwwsLwLmpwMDw""".split("\n");
        InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
        assertEquals(157, day3.part1(FileRead.readByLines(is)));
    }

    @Test
    void part1Test() {
        InputStream is = this.getClass().getResourceAsStream("input.txt");
        assertEquals(7826, day3.part1(FileRead.readByLines(is)));
    }
}