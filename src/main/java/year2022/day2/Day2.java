package year2022.day2;


import java.util.List;

public class Day2 {

    public int part1(List<String> lines) {

        int result = 0;

        for (String line : lines) {
            result += fightValue(line);
        }

        return result;
    }

    private int fightValue(String letters) {

        String elf = letters.substring(0, 1);
        String me = letters.substring(letters.length() - 1);
        int elfValue = signValue(elf);
        int meValue = signValue(me);

        switch (elfValue - meValue) {
            case 0: meValue += 3; break;
            case 1:
            case -2: meValue += 0; break;
            case -1:
            case 2: meValue += 6; break;
        }

        return meValue;
    }

    private int signValue(String letter) {

        switch (letter) {
            case "A":
            case "X": return 1;
            case "B":
            case "Y": return 2;
            case "C":
            case "Z": return 3;
            default: return 0;
        }
    }
}
