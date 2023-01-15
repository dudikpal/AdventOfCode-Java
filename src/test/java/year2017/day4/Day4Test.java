package year2017.day4;

import org.junit.jupiter.api.Test;
import utils.FileRead;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Day4Test {

	private Day4 day4 = new Day4();

	@Test
	void part1Example1Test() {
		String input = """
				aa bb cc dd aa
    			aa bb cc dd ee
				aa bb cc dd aaa""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(2, day4.part1(FileRead.readByLines(is)));
	}

	@Test
	void part1Test() {
		InputStream is = this.getClass().getResourceAsStream("input.txt");
		assertEquals(477, day4.part1(FileRead.readByLines(is)));
	}

	@Test
	void part2Example1Test() {
		String input = """
				abcde fghij
				abcde xyz ecdab
				a ab abc abd abf abj
				iiii oiii ooii oooi oooo
				oiii ioii iioi iiio""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(3, day4.part2(FileRead.readByLines(is)));
	}

	@Test
	void part2Test() {
		InputStream is = this.getClass().getResourceAsStream("input.txt");
		assertEquals(167, day4.part2(FileRead.readByLines(is)));
	}
}