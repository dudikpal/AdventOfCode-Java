package year2017.day8;

import org.junit.jupiter.api.Test;
import utils.FileRead;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Day8Test {

	private Day8 day8 = new Day8();

	@Test
	void part1Example1Test() {
		String input = """
				b inc 5 if a > 1
				a inc 1 if b < 5
				c dec -10 if a >= 1
				c inc -20 if c == 10""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(1, day8.part1(FileRead.readByLines(is)));
	}

	@Test
	void part1Test() {
		InputStream is = this.getClass().getResourceAsStream("input.txt");
		assertEquals(5075, day8.part1(FileRead.readByLines(is)));
	}

	@Test
	void part2Example1Test() {
		String input = """
				b inc 5 if a > 1
				a inc 1 if b < 5
				c dec -10 if a >= 1
				c inc -20 if c == 10""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(10, day8.part2(FileRead.readByLines(is)));
	}

	@Test
	void part2Test() {
		InputStream is = this.getClass().getResourceAsStream("input.txt");
		assertEquals(7310, day8.part2(FileRead.readByLines(is)));
	}

}