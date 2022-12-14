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

    public int part2(List<String> lines) {
        int result = 0;

        for (String line : lines) {
            result += requestEnding(line);
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

    private int requestEnding(String letters) {

        String elf = letters.substring(0, 1);
        String me = letters.substring(letters.length() - 1);
        int elfValue = signValue(elf);
        int meValue = 0;

        switch (me) {
            case "X": meValue = 0; break;
            case "Y": meValue = 3; break;
            case "Z": meValue = 6; break;
        }

        meValue += requestSign(meValue, elfValue);

        return meValue;
    }

    private int requestSign(int meValue, int elfValue) {

        switch (meValue) {
            case 0: return convertSignValue(elfValue - 1);
            case 3: return convertSignValue(elfValue);
            case 6: return convertSignValue(elfValue + 1);
            default: return 0;
        }
    }

    private int convertSignValue(int signValue) {

        switch (signValue) {
            case 0: return 3;
            case 4: return 1;
            default: return signValue;
        }
    }
}
