package year2017.day6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Day6 {

	public int part1(List <String> lines) {

		List<Integer> banks = Arrays.stream(lines.get(0).split("\t"))
				.map(str -> Integer.parseInt(str))
				.collect(Collectors.toList());
		HashSet<String> bankStates = new HashSet <>();
		int divider = banks.size() - 1;
		int stepCount = 0;

		while (true) {
			stepCount++;
			int dividedValue = banks.stream()
					.max(Comparator.comparing(Integer::intValue))
					.get();
			int dividedBankIndex = banks.indexOf(dividedValue);
			int repeat = dividedValue / divider;
			banks.set(dividedBankIndex, 0);

			for (int j = 0; j < repeat + 1; j++) {

				for (int i = 0; i < banks.size(); i++) {

					if (dividedValue == 0) {
						break;
					}
					int absolutIndex = (dividedBankIndex + i + 1) % (divider + 1);
					banks.set(absolutIndex, banks.get(absolutIndex) + 1);
					dividedValue--;
				}
			}


			bankStates.add(banks.toString());

			if (bankStates.size() != stepCount) {
				break;
			}
		}

		return stepCount;
	}

	public int part2(List <String> lines) {
		List<Integer> banks = Arrays.stream(lines.get(0).split("\t"))
				.map(str -> Integer.parseInt(str))
				.collect(Collectors.toList());
		HashSet<String> bankStates = new HashSet <>();
		int divider = banks.size() - 1;
		int stepCount = 0;
		int cycle = 1;

		while (true) {
			stepCount++;
			int dividedValue = banks.stream()
					.max(Comparator.comparing(Integer::intValue))
					.get();
			int dividedBankIndex = banks.indexOf(dividedValue);
			int repeat = dividedValue / divider;
			banks.set(dividedBankIndex, 0);

			for (int j = 0; j < repeat + 1; j++) {

				for (int i = 0; i < banks.size(); i++) {

					if (dividedValue == 0) {
						break;
					}
					int absolutIndex = (dividedBankIndex + i + 1) % (divider + 1);
					banks.set(absolutIndex, banks.get(absolutIndex) + 1);
					dividedValue--;
				}
			}

			bankStates.add(banks.toString());


			if (bankStates.size() != stepCount) {
				cycle++;
				if (cycle == 3) {
					break;
				}
				String firstSet = banks.toString();
				bankStates = new HashSet <>();
				bankStates.add(firstSet);
				stepCount = 1;
			}

		}

		return stepCount - 1;
	}
}
