package year2017.day7;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day7 {

	private String root;

	private List <String> lines;

	private Map <String, Integer> towers;

	public String part1(List <String> lines) {

		Pattern bottomPattern = Pattern.compile("^\\w+");

		List <String> bottoms = lines.stream()
				.map(str -> {
					Matcher m = bottomPattern.matcher(str);
					m.find();

					return m.group();
				})
				.collect(Collectors.toList());

		Pattern discsPattern = Pattern.compile("[\\w+,\\s]+$");
		List <String> toppers = new ArrayList <>();
		lines.stream()
				.map(discs -> {
					Matcher m = discsPattern.matcher(discs);

					while (m.find()) {
						String[] toppersArray = m.group().trim().split(", ");
						toppers.addAll(Arrays.asList(toppersArray));
					}

					return 0;
				})
				.collect(Collectors.toList());
		bottoms.removeAll(toppers);

		return bottoms.get(0);
	}

	public int part2(List <String> lines) {

		this.lines = lines;
		root = part1(lines);

		towers = new HashMap <>();
		Pattern towerPattern = Pattern.compile("^.*\\)");

		for (String line : lines) {
			Matcher towerMatcher = towerPattern.matcher(line);
			towerMatcher.find();
			String[] tower = towerMatcher.group().trim().replaceAll("[\\(\\)]", "").split(" ");
			towers.put(tower[0], Integer.parseInt(tower[1]));
		}

		getSubTowers(root);

		return 0;
	}

	private int getTowerValue(String tower) {
		return towers.get(tower);
	}

	private int getSubTowers(String parentTower) {

		Pattern subTowerPattern = Pattern.compile("[\\w+,\\s]+$");
		String parentTowerLine = lines.stream()
				.filter(tower -> tower.startsWith(parentTower))
				.collect(Collectors.joining());
		Matcher subTowerMatcher = subTowerPattern.matcher(parentTowerLine);
		List <String> subtowers = new ArrayList <>();

		if (!subTowerMatcher.find()) {
			//System.out.println(parentTower + ": " + getTowerValue(parentTower));
			return getTowerValue(parentTower);
		} else {

			subtowers.addAll(Arrays.asList(subTowerMatcher.group().trim().split(", ")));
			//System.out.println(parentTowerLine);
			int sumOfTowersValue = 0;

			for (String subtower : subtowers) {
				sumOfTowersValue += getSubTowers(subtower);
			}
			//System.out.println(parentTower + ": " + (sumOfTowersValue + getTowerValue(parentTower)));
			return getTowerValue(parentTower) + sumOfTowersValue;
		}
	}
}
