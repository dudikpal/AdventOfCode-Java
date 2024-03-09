package year2023.day2;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2 {

	private int red;
	private int green;
	private int blue;

	public int part1(List <String> inputList) {

		red = 12;
		green = 13;
		blue = 14;
		int result = 0;

		for (String line : inputList) {
			String[] lineParts = line.split(":");
			Pattern patternOfNumber = Pattern.compile("\\d+");
			Matcher gameIdMatcher = patternOfNumber.matcher(lineParts[0]);
			gameIdMatcher.find();
			int gameId = Integer.parseInt(gameIdMatcher.group());
			String[] reveals = lineParts[1].split(";");
			boolean gameIsPossible = true;


			OUTER: for (String reveal : reveals) {

				String[] revealedCubes = reveal.split(",");

				INNER: for (String cube : revealedCubes) {

					Matcher numberOfCubeMatcher = patternOfNumber.matcher(cube);
					numberOfCubeMatcher.find();
					int count = Integer.parseInt(numberOfCubeMatcher.group());
					Pattern patternOfColor = Pattern.compile("[a-z]+");
					Matcher colorMatcher = patternOfColor.matcher(cube);
					colorMatcher.find();
					String color = colorMatcher.group();

					if (!cubePossible(color, count)) {
						gameIsPossible = false;
						break;
					}
				}
			}

			if (gameIsPossible) {
				result += gameId;
			}
		}

		return result;
	}

	public int part2(List <String> inputList) {

		int result = 0;

		for (String line : inputList) {
			red = 0;
			green = 0;
			blue = 0;
			String[] lineParts = line.split(":");
			Pattern patternOfNumber = Pattern.compile("\\d+");
			String[] reveals = lineParts[1].split(";");

			for (String reveal : reveals) {

				String[] revealedCubes = reveal.split(",");

				for (String cube : revealedCubes) {

					Matcher numberOfCubeMatcher = patternOfNumber.matcher(cube);
					numberOfCubeMatcher.find();
					int count = Integer.parseInt(numberOfCubeMatcher.group());
					Pattern patternOfColor = Pattern.compile("[a-z]+");
					Matcher colorMatcher = patternOfColor.matcher(cube);
					colorMatcher.find();
					String color = colorMatcher.group();
					setFewestCube(color, count);
				}
			}
			result += red * green * blue;
		}

		return result;
	}

	private void setFewestCube(String color, int count) {

		switch (color) {
			case "red":
				if (red < count) red = count;
				break;
			case "green":
				if (green < count) green = count;
				break;
			case "blue":
				if (blue < count) blue = count;
				break;
			default: ;
		}
	}

	private boolean cubePossible(String color, int count) {

		int maxCount = switch (color) {
			case "red" -> red;
			case "green" -> green;
			case "blue" -> blue;
			default -> 0;
		};

		return maxCount >= count;
	}
}
