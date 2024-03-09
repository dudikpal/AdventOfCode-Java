package year2023.day2;

import org.junit.jupiter.api.Test;
import utils.FileRead;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day2Test {

	private Day2 day2 = new Day2();
	private String input = """
				Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
				Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
				Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
				Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
				Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green""";

	@Test
	void part1ExampleTest() {
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(8, day2.part1(FileRead.readByLines(is)));
	}

	@Test
	void part1Test() {
		InputStream is = this.getClass().getResourceAsStream("input.txt");
		assertEquals(2331, day2.part1(FileRead.readByLines(is)));
	}

	@Test
	void part2ExampleTest() {
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(2286, day2.part2(FileRead.readByLines(is)));
	}

	@Test
	void part2Test() {
		InputStream is = this.getClass().getResourceAsStream("input.txt");
		assertEquals(71585, day2.part2(FileRead.readByLines(is)));
	}
}
