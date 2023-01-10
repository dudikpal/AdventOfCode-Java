package year2017.day1;

import java.util.List;

public class Day1 {

	public int part1(List <String> lines) {

		String numbers = lines.get(0);
		int distance = 1;

		return getSum(numbers, distance);
	}

	public int part2(List <String> lines) {

		String numbers = lines.get(0);
		int distance = numbers.length() / 2;

		return getSum(numbers, distance);
	}

	private int getSum(String numbers, int distance) {

		int sum = 0;

		sum += getFirstHalfOfSum(numbers, distance);
		sum += getSecondHalfOfSum(numbers, distance);

		return sum;
	}

	private int getSecondHalfOfSum(String numbers, int distance) {

		int sum = 0;

		for (int i = numbers.length() - distance; i < numbers.length(); i++) {
			if (numbers.charAt(i) == numbers.charAt(i - (numbers.length() - distance))) {
				sum += Integer.parseInt(numbers.substring(i, i + 1));
			}
		}

		return sum;
	}

	private int getFirstHalfOfSum(String numbers, int distance) {

		int sum = 0;

		for (int i = 0; i < numbers.length() - distance; i++) {
			if (numbers.charAt(i) == numbers.charAt(i + distance)) {
				sum += Integer.parseInt(numbers.substring(i, i + 1));
			}
		}

		return sum;
	}
}
