package year2017.day3;

import org.junit.jupiter.api.Test;
import utils.FileRead;
import year2017.day2.Day2;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Day3Test {

	private Day3 day3 = new Day3();

	@Test
	void part1Example1Test() {
		String input = """
				12""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(3, day3.part1(FileRead.readByLines(is)));
	}

	@Test
	void part1Example2Test() {
		String input = """
				23""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(2, day3.part1(FileRead.readByLines(is)));
	}

	@Test
	void part1Example3Test() {
		String input = """
				1024""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(31, day3.part1(FileRead.readByLines(is)));
	}

	@Test
	void part1() {
		InputStream is = this.getClass().getResourceAsStream("input.txt");
		assertEquals(326, day3.part1(FileRead.readByLines(is)));
	}

	@Test
	void part2Example1Test() {
		String input = """
				748""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(806, day3.part2(FileRead.readByLines(is)));
	}

	@Test
	void part2() {
		InputStream is = this.getClass().getResourceAsStream("input.txt");
		assertEquals(363010, day3.part2(FileRead.readByLines(is)));
	}
}