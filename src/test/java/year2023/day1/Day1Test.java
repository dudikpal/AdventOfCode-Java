package year2023.day1;

import org.junit.jupiter.api.Test;
import utils.FileRead;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Day1Test {

	private Day1 day1 = new Day1();

	@Test
	void part1ExampleTest() {
		String input = """
				1abc2
				pqr3stu8vwx
				a1b2c3d4e5f
				treb7uchet""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(142, day1.part1(FileRead.readByLines(is)));
	}

	@Test
	void part1Test() {
		InputStream is = this.getClass().getResourceAsStream("input.txt");
		assertEquals(54388, day1.part1(FileRead.readByLines(is)));
	}

	@Test
	void part2ExampleTest() {
		String input = """
				two1nine
				eightwothree
				abcone2threexyz
				xtwone3four
				4nineeightseven2
				zoneight234
				7pqrstsixteen""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(281, day1.part2(FileRead.readByLines(is)));
	}

	@Test
	void part2ExampleTest2() {
		String input = """
				two1nine
				eightwothreeight
				abcone2threexyz
				xtwone3four
				4nineeightseven2
				zoneight234
				7pqrstsixteen""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(286, day1.part2(FileRead.readByLines(is)));
	}

	@Test
	void part2Test() {
		InputStream is = this.getClass().getResourceAsStream("input.txt");
		assertEquals(53515, day1.part2(FileRead.readByLines(is)));
	}
}