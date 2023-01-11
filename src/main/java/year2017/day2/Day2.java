package year2017.day2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day2 {

	public int part1(List <String> lines) {

		int checksum = 0;

		for (String line : lines) {
			List<Integer> numbers = getNumberList(line);
			int maxValue = numbers.stream()
					.max(Integer::compareTo)
					.get();
			int minValue = numbers.stream()
					.min(Integer::compareTo)
					.get();

			checksum += maxValue - minValue;
		}

		return checksum;
	}

	public int part2(List<String> lines) {

		int checksum = 0;

		for (String line : lines) {
			List<Integer> numbers = getNumberList(line);
			checksum += evenlyDiv(numbers);
		}

		return checksum;
	}

	private List<Integer> getNumberList(String line) {
		return Arrays.stream(line.split("[\\t\\s]+"))
				.map(str -> Integer.parseInt(str))
				.collect(Collectors.toList());
	}

	private int evenlyDiv(List<Integer> numbers) {

		for (int i = 0; i < numbers.size(); i++) {

			for (int j = 0; j < numbers.size(); j++) {
				int num1 = numbers.get(i);
				int num2 = numbers.get(j);
				int div1 = num1 % num2;
				int div2 = num2 % num1;

				if (i != j && (div1 == 0 || div2 == 0)) {
					return 	div1 == 0 ? num1 / num2 : num2 / num1;
				}
			}
		}
		return 0;
	}

}
