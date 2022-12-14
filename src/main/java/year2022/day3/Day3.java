package year2022.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Day3 {

    public int part1(List<String> lines) {

        int result = 0;

        for (String line : lines) {
            List<String> firstCompartment = Arrays.stream(line.substring(0, line.length() / 2).split("")).collect(Collectors.toList());
            List<String> secondCompartment = Arrays.stream(line.substring(line.length() / 2).split("")).collect(Collectors.toList());
            List<List<String>> rucksocks = new ArrayList<>(){{
                add(firstCompartment);
                add(secondCompartment);
            }};
            List<String> badge = getDuplicatedItem(rucksocks);
            result += getCharValue(badge.get(0).charAt(0));
        }

        return result;
    }

    public int part2(List<String> lines) {

        int result = 0;

        for (int i = 0; i < lines.size(); i+=3) {
            List<String> firstSock = Arrays.stream(lines.get(i).split("")).collect(Collectors.toList());
            List<String> secondSock = Arrays.stream(lines.get(i + 1).split("")).collect(Collectors.toList());
            List<String> firstIteration = getDuplicatedItem(new ArrayList<>(){{
                add(firstSock);
                add(secondSock);
            }});
            List<String> thirdSock = Arrays.stream(lines.get(i + 2).split("")).collect(Collectors.toList());
            List<String> secondIteration = getDuplicatedItem(new ArrayList<>(){{
                add(firstIteration);
                add(thirdSock);
            }});
            result += getCharValue(secondIteration.get(0).charAt(0));
        }

        return result;
    }

    private List<String> getDuplicatedItem(List<List<String>> rucksacks) {

        List<String> result = rucksacks.get(0).stream()
                .filter(letter -> rucksacks.get(1).contains(letter))
                .collect(Collectors.toList());

        return result;
    }

    private int getCharValue(char letter) {
        return Character.isUpperCase(letter) ? letter - 38 : letter - 96;
    }
}
