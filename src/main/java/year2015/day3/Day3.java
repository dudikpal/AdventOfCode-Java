package year2015.day3;

import utils.FileRead;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day3 {

    private Set<Position> positions;
    private List<String> commands;

    public int part1() {
        positions = new HashSet<>();
        int x = 0;
        int y = 0;
        positions.add(new Position(x, y));
        for (int i = 0; i < commands.get(0).length(); i++) {
            char vector = commands.get(0).charAt(i);
            Position pos = calculatePosition(vector, x, y);
            x = pos.getxCoord();
            y = pos.getyCoord();
            positions.add(pos);
        }
        return positions.size();
    }

    private Position calculatePosition(char vector, int x, int y) {
        if (vector == '^') {
            return new Position(x, ++y);
        } else if (vector == 'v') {
            return new Position(x, --y);
        } else if (vector == '>') {
            return new Position(++x, y);
        } else {
            return new Position(--x, y);
        }
    }

    public int part2() {
        positions = new HashSet<>();
        int xSanta = 0;
        int ySanta = 0;
        int xRobo = 0;
        int yRobo = 0;
        positions.add(new Position(xSanta, ySanta));
        positions.add(new Position(xRobo, yRobo));
        for (int i = 0; i < commands.get(0).length(); i++) {
            char vector = commands.get(0).charAt(i);
            if (i % 2 == 0) {
                Position pos = calculatePosition(vector, xSanta, ySanta);
                xSanta = pos.getxCoord();
                ySanta = pos.getyCoord();
                positions.add(pos);
            } else {
                Position pos = calculatePosition(vector, xRobo, yRobo);
                xRobo = pos.getxCoord();
                yRobo = pos.getyCoord();
                positions.add(pos);
            }
        }
        return positions.size();
    }

    public void fileRead(BufferedReader bf) {
        commands = new ArrayList<>(FileRead.readFile(bf));
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