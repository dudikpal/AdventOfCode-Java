package year2017.day9;

import java.util.List;

public class Day9 {

	public int part1(List <String> lines) {
		String charStream = lines.get(0);
		StringBuilder sb = new StringBuilder(charStream);
		int level = 0;
		int result = 0;
		boolean inGarbage = false;

		for (int i = 0; i < sb.length(); i++) {
			char letter = sb.charAt(i);

			if (letter == '!') {
				i++;
			} else if (letter == '>') {
				inGarbage = false;
			} else if (inGarbage) {
				continue;
			} else if (letter == '<') {
				inGarbage = true;
			} else if (letter == '{') {
				result += ++level;
			} else if (letter == '}') {
				level--;
			}
		}

		return result;
	}

	public int part2(List <String> lines) {
		String charStream = lines.get(0);
		StringBuilder sb = new StringBuilder(charStream);
		int level = 0;
		boolean inGarbage = false;
		int garbageLetters = 0;

		for (int i = 0; i < sb.length(); i++) {
			char letter = sb.charAt(i);

			if (letter == '!') {
				i++;
			} else if (letter == '>') {
				inGarbage = false;
			} else if (inGarbage) {
				garbageLetters++;
			} else if (letter == '<') {
				inGarbage = true;
			}
		}

		return garbageLetters;
	}
}
