package year2023.day1;

import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day1 {

	public static void main(String[] args) {
		Main main = new Main();
		Day1 day1 = new Day1();
	}

	public int part1(List <String> inputList) {

		List <Integer> numbers = new ArrayList <>();

		for (String line : inputList) {

			Pattern pattern = Pattern.compile("\\d");
			Matcher matcher = pattern.matcher(line);
			String resultString = "";

			while (matcher.find()) {
				resultString += matcher.group();
			}
			String number = resultString.substring(0, 1).concat(resultString.substring(resultString.length() - 1));
			numbers.add(Integer.parseInt(number));
		}

		return numbers.stream().mapToInt(Integer::intValue).sum();
	}

	public int part2(List <String> inputList) {
		int result = 0;

		for (String line : inputList) {
			result += Integer.parseInt(getNumber(line));
		}

		return result;
	}

	private String getNumber(String line) {
		int firstIndex = Integer.MAX_VALUE;
		int lastIndex = -1;
		String firstNumber = "0";
		String lastNumber = "0";

		for (String numberString : numberStrings()) {

			if (line.indexOf(numberString) != -1 && line.indexOf(numberString) < firstIndex) {
				firstNumber = convertToNumberString(numberString);
				firstIndex = line.indexOf(numberString);
			}

			if (line.lastIndexOf(numberString) > lastIndex) {
				lastNumber = convertToNumberString(numberString);
				lastIndex = line.lastIndexOf(numberString);
			}
		}

		return firstNumber.concat(lastNumber);
	}

	private String convertToNumberString(String number) {

		return switch (number) {
			case "1", "one" -> "1";
			case "2", "two" -> "2";
			case "3", "three" -> "3";
			case "4", "four" -> "4";
			case "5", "five" -> "5";
			case "6", "six" -> "6";
			case "7", "seven" -> "7";
			case "8", "eight" -> "8";
			case "9", "nine" -> "9";
			default -> "";
		};
	}

	private List <String> numberStrings() {
		return List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "1", "2", "3", "4", "5", "6", "7", "8", "9");
	}
}
