package year2022.day4;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day4 {

    public int part1(List<String> lines) {

        int result = 0;

        for (String line : lines) {

            List<Integer> elf1Cells = getElfCells(line.split(",")[0]);
            List<Integer> elf2Cells = getElfCells(line.split(",")[1]);

            if (elf1Cells.containsAll(elf2Cells) || elf2Cells.containsAll(elf1Cells)) {
                result++;
            }

        }
        return result;
    }

    public int part2(List<String> lines) {

        int result = 0;

        for (String line : lines) {

            List<Integer> elf1Cells = getElfCells(line.split(",")[0]);
            List<Integer> elf2Cells = getElfCells(line.split(",")[1]);

            if (elf1Cells.stream().filter(num -> elf2Cells.contains(num)).collect(Collectors.toList()).size() > 0) {
                result++;
            }
        }
        return result;
    }

    private List<Integer> getElfCells(String elfRangeString) {

        String[] elfRange = elfRangeString.split("-");
        int elfStart = Integer.parseInt(elfRange[0]);
        int elfEnd = Integer.parseInt(elfRange[1]);

        return IntStream.rangeClosed(elfStart, elfEnd)
                .boxed()
                .collect(Collectors.toList());

    }
}
