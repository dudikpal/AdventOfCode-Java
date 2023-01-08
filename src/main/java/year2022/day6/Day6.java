package year2022.day6;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day6 {

	public int part1(List <String> lines) {

		return getFirstMarker(lines.get(0), 4);
	}

	public int part2(List <String> lines) {

		return getFirstMarker(lines.get(0), 14);
	}

	private int getFirstMarker(String line, int distinct) {
		Pattern p = Pattern.compile("(\\w).*?\\1+");

		for (int i = 0; i < line.length() - distinct - 1; i++) {

			Matcher m = p.matcher(line.substring(i, i + distinct));

			if (!m.find()) {
				return i + distinct;
			}
		}

		return 0;
	}
}
