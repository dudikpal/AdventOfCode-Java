package year2017.day9;

import org.junit.jupiter.api.Test;
import utils.FileRead;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Day9Test {

	private Day9 day9 = new Day9();

	@Test
	void part1Example1Test() {
		String input = """
				{}""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(1, day9.part1(FileRead.readByLines(is)));
	}

	@Test
	void part1Example2Test() {
		String input = """
				{{{}}}""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(6, day9.part1(FileRead.readByLines(is)));
	}

	@Test
	void part1Example3Test() {
		String input = """
				{<!!!>>{<!!}!>>},{<{!>}>}<<<<>}""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(5, day9.part1(FileRead.readByLines(is)));
	}

	@Test
	void part1Example4Test() {
		String input = """
				{{{},{},{{}}}}""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(16, day9.part1(FileRead.readByLines(is)));
	}

	@Test
	void part1Example5Test() {
		String input = """
				{<a>,<a>,<a>,<a>}""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(1, day9.part1(FileRead.readByLines(is)));
	}

	@Test
	void part1Example6Test() {
		String input = """
				{{<ab>},{<ab>},{<ab>},{<ab>}}""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(9, day9.part1(FileRead.readByLines(is)));
	}

	@Test
	void part1Example7Test() {
		String input = """
				{{<!!>},{<!!>},{<!!>},{<!!>}}""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(9, day9.part1(FileRead.readByLines(is)));
	}

	@Test
	void part1Example8Test() {
		String input = """
				{{<a!>},{<a!>},{<a!>},{<ab>}}""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(3, day9.part1(FileRead.readByLines(is)));
	}

	@Test
	void part1Test() {
		InputStream is = this.getClass().getResourceAsStream("input.txt");
		assertEquals(11347, day9.part1(FileRead.readByLines(is)));
	}

	@Test
	void part2Example1Test() {
		String input = """
				<>""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(0, day9.part2(FileRead.readByLines(is)));
	}

	@Test
	void part2Example2Test() {
		String input = """
				<random characters>""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(17, day9.part2(FileRead.readByLines(is)));
	}

	@Test
	void part2Example3Test() {
		String input = """
				<<<<>""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(3, day9.part2(FileRead.readByLines(is)));
	}

	@Test
	void part2Example4Test() {
		String input = """
				<{!>}>""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(2, day9.part2(FileRead.readByLines(is)));
	}

	@Test
	void part2Example5Test() {
		String input = """
				<!!>""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(0, day9.part2(FileRead.readByLines(is)));
	}

	@Test
	void part2Example6Test() {
		String input = """
				<!!!>>""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(0, day9.part2(FileRead.readByLines(is)));
	}

	@Test
	void part2Example7Test() {
		String input = """
				<{o"i!a,<{i<a>""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(10, day9.part2(FileRead.readByLines(is)));
	}

	@Test
	void part2Test() {
		InputStream is = this.getClass().getResourceAsStream("input.txt");
		assertEquals(5404, day9.part2(FileRead.readByLines(is)));
	}

}