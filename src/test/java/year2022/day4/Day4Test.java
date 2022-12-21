package year2022.day4;

import org.junit.jupiter.api.Test;
import utils.FileRead;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class Day4Test {

    private Day4 day4 = new Day4();

    @Test
    void part1() {

        InputStream is = this.getClass().getResourceAsStream("input.txt");
        assertEquals(562, day4.part1(FileRead.readByLines(is)));
    }

    @Test
    void part2() {
        InputStream is = this.getClass().getResourceAsStream("input.txt");
        assertEquals(924, day4.part2(FileRead.readByLines(is)));
    }
}