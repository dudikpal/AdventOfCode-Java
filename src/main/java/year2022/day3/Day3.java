package year2022.day3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day3 {

    public int part1(List<String> lines) {

        int result = 0;

        for (String line : lines) {
            result += getCharValue(getDuplicatedItem(line));
        }

        return result;
    }

    private char getDuplicatedItem(String rucksack) {
        List<String> firstCompartment = Arrays.stream(rucksack.substring(0, rucksack.length() / 2).split("")).collect(Collectors.toList());
        List<String> secondCompartment = Arrays.stream(rucksack.substring(rucksack.length() / 2).split("")).collect(Collectors.toList());

        String result = firstCompartment.stream()
                .filter(letter -> secondCompartment.contains(letter))
                .findFirst()
                .get();

        return result.charAt(0);
    }

    private int getCharValue(char letter) {
        return Character.isUpperCase(letter) ? letter - 38 : letter - 96;
    }
}
