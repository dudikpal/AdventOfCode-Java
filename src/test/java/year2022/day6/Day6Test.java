package year2022.day6;

import org.junit.jupiter.api.Test;
import utils.FileRead;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Day6Test {

	private Day6 day6 = new Day6();

	@Test
	void part1Example1Test() {
		String input = """
				mjqjpqmgbljsphdztnvjfqwrcgsmlb""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(7, day6.part1(FileRead.readByLines(is)));
	}

	@Test
	void part1Example2Test() {
		String input = """
				bvwbjplbgvbhsrlpgdmjqwftvncz""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(5, day6.part1(FileRead.readByLines(is)));
	}

	@Test
	void part1Example3Test() {
		String input = """
				zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(11, day6.part1(FileRead.readByLines(is)));
	}

	@Test
	void part1() {
		InputStream is = this.getClass().getResourceAsStream("input.txt");
		assertEquals(1929, day6.part1(FileRead.readByLines(is)));
	}

	@Test
	void part2Example1Test() {
		String input = """
				mjqjpqmgbljsphdztnvjfqwrcgsmlb""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(19, day6.part2(FileRead.readByLines(is)));
	}

	@Test
	void part2Example2Test() {
		String input = """
				bvwbjplbgvbhsrlpgdmjqwftvncz""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(23, day6.part2(FileRead.readByLines(is)));
	}

	@Test
	void part2Example3Test() {
		String input = """
				zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(26, day6.part2(FileRead.readByLines(is)));
	}

	@Test
	void part2() {
		InputStream is = this.getClass().getResourceAsStream("input.txt");
		assertEquals(3298, day6.part2(FileRead.readByLines(is)));
	}
}