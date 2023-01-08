package year2022.day5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day5 {

	private List<LinkedList<Character>> cargoShip;

	private List<String> commands;

	public String part1(List <String> lines) {

		createCargoShip(lines);

		for (String command : commands) {
			runCommandCrane9000(parseCommand(command));
		}

		return getFirstChars();
	}

	public String part2(List<String> lines) {

		createCargoShip(lines);

		for (String command : commands) {
			runCommandCrane9001(parseCommand(command));
		}

		return getFirstChars();
	}

	private void runCommandCrane9000(List<String> parsedCommands) {
		int pcs = Integer.parseInt(parsedCommands.get(0));
		int from = Integer.parseInt(parsedCommands.get(1)) - 1;
		int to = Integer.parseInt(parsedCommands.get(2)) - 1;

		for (int i = 0; i < pcs; i++) {
			char letter = cargoShip.get(from).pop();
			cargoShip.get(to).push(letter);
		}
	}

	private void runCommandCrane9001(List<String> parsedCommands) {
		int pcs = Integer.parseInt(parsedCommands.get(0));
		int from = Integer.parseInt(parsedCommands.get(1)) - 1;
		int to = Integer.parseInt(parsedCommands.get(2)) - 1;

		for (int i = pcs - 1; i >= 0; i--) {
			char letter = cargoShip.get(from).remove(i);
			cargoShip.get(to).push(letter);
		}
	}

	private String getFirstChars() {
		return String.join("",
				cargoShip.stream()
					.map(stack -> stack.peekFirst().toString())
					.collect(Collectors.toList()));
	}

	private List<String> parseCommand(String command) {
		Pattern p = Pattern.compile("(\\d+)");
		Matcher m = p.matcher(command);
		List<String> numbers = new ArrayList <>();

		while (m.find()) {
			numbers.add(m.group());
		}

		return numbers;
	}

	private void createCargoShip(List <String> lines) {

		cargoShip = new ArrayList <>();
		lines = getFormattedShip(lines);
		List<String> shipByLine = new ArrayList <>();
		commands = new ArrayList <>();
		boolean isShip = true;

		for (String line : lines) {

			if (line.isEmpty()) {
				isShip = false;
				continue;
			}

			if (isShip) {
				shipByLine.add(line);
			} else {
				commands.add(line);
			}
		}

		int numberOfStack = shipByLine.get(0).length();

		for (int i = 0; i < numberOfStack; i++) {
			cargoShip.add(new LinkedList <>());
		}

		for (int i = 0; i < shipByLine.size() - 1; i++) {

			for (int j = 0; j < numberOfStack; j++) {

				if (shipByLine.get(i).charAt(j) != ' ') {
					cargoShip.get(j).add(shipByLine.get(i).charAt(j));
				}
			}
		}
	}

	private List<String> getFormattedShip(List<String> lines) {
		return lines.stream()
				.map(line -> line
						.replaceAll("\s\\[", "")
						.replaceAll("\\]\s", "")
						.replaceAll("[\\[\\]]", "")
						.replaceAll("\s{4}", " ")
						.replaceAll("\s{3}", " ")
				)
				.collect(Collectors.toList());
	}
}
