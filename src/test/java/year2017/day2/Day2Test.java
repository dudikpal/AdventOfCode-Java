package year2017.day2;

import org.junit.jupiter.api.Test;
import utils.FileRead;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Day2Test {

	private Day2 day2 = new Day2();

	@Test
	void part1Example1Test() {
		String input = """
				5	1 9 5
				7 5	3
				2 4 6 8""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(18, day2.part1(FileRead.readByLines(is)));
	}

	@Test
	void part1() {
		InputStream is = this.getClass().getResourceAsStream("input.txt");
		assertEquals(47136, day2.part1(FileRead.readByLines(is)));
	}

	@Test
	void part2Example1Test() {
		String input = """
				5 9 2 8
				9 4 7 3
				3 8 6 5""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(9, day2.part2(FileRead.readByLines(is)));
	}

	@Test
	void part2() {
		InputStream is = this.getClass().getResourceAsStream("input.txt");
		assertEquals(250, day2.part2(FileRead.readByLines(is)));
	}
}