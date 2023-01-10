package year2017.day1;

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
	void part1Example1Test() {
		String input = """
				91212129""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(9, day1.part1(FileRead.readByLines(is)));
	}

	@Test
	void part1Test() {
		InputStream is = this.getClass().getResourceAsStream("input.txt");
		assertEquals(1158, day1.part1(FileRead.readByLines(is)));
	}

	@Test
	void part2Example1Test() {
		String input = """
				1212""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(6, day1.part2(FileRead.readByLines(is)));
	}

	@Test
	void part2Example2Test() {
		String input = """
				12131415""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(4, day1.part2(FileRead.readByLines(is)));
	}

	@Test
	void part2Test() {
		InputStream is = this.getClass().getResourceAsStream("input.txt");
		assertEquals(1132, day1.part2(FileRead.readByLines(is)));
	}
}