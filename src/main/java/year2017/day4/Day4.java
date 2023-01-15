package year2017.day4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Day4 {

	public int part1(List <String> lines) {

		int validCount = 0;

		for (String line : lines) {

			HashSet distinctWords = new HashSet();
			String[] words = line.split(" ");

			for (String word : words) {
				distinctWords.add(word);
			}

			if (words.length == distinctWords.size()) {
				validCount++;
			}
		}

		return validCount;
	}

	public int part2(List <String> lines) {

		int validCount = 0;

		for (String line : lines) {

			HashSet<String> validWords = new HashSet <>();
			String[] words = line.split(" ");

			for (String word : words) {
				char[] wordLetters = word.toCharArray();
				Arrays.sort(wordLetters);
				validWords.add(String.valueOf(wordLetters));
			}

			if (words.length == validWords.size()) {
				validCount++;
			}
		}

		return validCount;
	}
}
