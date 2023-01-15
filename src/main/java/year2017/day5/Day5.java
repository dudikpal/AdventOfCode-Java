package year2017.day5;

import java.util.List;
import java.util.stream.Collectors;

public class Day5 {

	public int part1(List <String> lines) {

		List<Integer> commands = lines.stream()
				.map(str -> Integer.parseInt(str))
				.collect(Collectors.toList());
		int stepCount = 0;
		int actualLine = 0;

		while (commands.size() > actualLine) {
			int gotoLine = commands.get(actualLine);
			commands.set(actualLine, commands.get(actualLine) + 1);
			actualLine = actualLine + gotoLine;
			stepCount++;
		}

		return stepCount;
	}

	public int part2(List <String> lines) {

		List<Integer> commands = lines.stream()
				.map(str -> Integer.parseInt(str))
				.collect(Collectors.toList());
		int stepCount = 0;
		int actualLine = 0;

		while (commands.size() > actualLine) {
			int gotoLine = commands.get(actualLine);

			if (gotoLine > 2) {
				commands.set(actualLine, commands.get(actualLine) - 1);
			} else {
				commands.set(actualLine, commands.get(actualLine) + 1);
			}

			actualLine = actualLine + gotoLine;
			stepCount++;
		}

		return stepCount;
	}
}
