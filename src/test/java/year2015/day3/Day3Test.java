package year2015.day3;

import org.junit.jupiter.api.Test;
import utils.FileRead;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

class Day3Test {

    private Day3 day3 = new Day3();

    @Test
    void part1Example() {
        String route = "^>ˇ<";

        day3.fileRead(new BufferedReader(new StringReader(route)));

        assertEquals(4, day3.part1());
    }

    @Test
    void part1() {
        InputStream is = this.getClass().getResourceAsStream("input.txt");

        day3.fileRead(new BufferedReader(new InputStreamReader(is)));

        assertEquals(2565, day3.part1());
    }

    @Test
    void part2Example() {
        String route = "^v^v^v^v^v";

        day3.fileRead(new BufferedReader(new StringReader(route)));

        assertEquals(11, day3.part2());
    }

    @Test
    void part2() {
        InputStream is = this.getClass().getResourceAsStream("input.txt");

        day3.fileRead(new BufferedReader(new InputStreamReader(is)));

        assertEquals(2639, day3.part2());
    }

}


/*
--- Day 3: Perfectly Spherical Houses in a Vacuum ---

Santa is delivering presents to an infinite two-dimensional grid of houses.

He begins by delivering a present to the house at his starting location, and then an elf at the North Pole calls him via radio and tells him where to move next. Moves are always exactly one house to the north (^), south (v), east (>), or west (<). After each move, he delivers another present to the house at his new location.

However, the elf back at the north pole has had a little too much eggnog, and so his directions are a little off, and Santa ends up visiting some houses more than once. How many houses receive at least one present?

For example:

    > delivers presents to 2 houses: one at the starting location, and one to the east.
    ^>v< delivers presents to 4 houses in a square, including twice to the house at his starting/ending location.
    ^v^v^v^v^v delivers a bunch of presents to some very lucky children at only 2 houses.

Your puzzle answer was 2565.
--- Part Two ---

The next year, to speed up the process, Santa creates a robot version of himself, Robo-Santa, to deliver presents with him.

Santa and Robo-Santa start at the same location (delivering two presents to the same starting house), then take turns moving based on instructions from the elf, who is eggnoggedly reading from the same script as the previous year.

This year, how many houses receive at least one present?

For example:

    ^v delivers presents to 3 houses, because Santa goes north, and then Robo-Santa goes south.
    ^>v< now delivers presents to 3 houses, and Santa and Robo-Santa end up back where they started.
    ^v^v^v^v^v now delivers presents to 11 houses, with Santa going one direction and Robo-Santa going the other.

Your puzzle answer was 2639.
 */