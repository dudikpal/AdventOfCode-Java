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
