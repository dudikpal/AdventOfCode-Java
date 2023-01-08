package year2022.day5;

import org.junit.jupiter.api.Test;
import utils.FileRead;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Day5Test {

	private Day5 day5 = new Day5();

	@Test
	void part1ExampleTest() {
		String input = """
				    [D]   \s
				[N] [C]   \s
				[Z] [M] [P]
				 1   2   3\s
				    
				move 1 from 2 to 1
				move 3 from 1 to 3
				move 2 from 2 to 1
				move 1 from 1 to 2""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals("CMZ", day5.part1(FileRead.readByLines(is)));
	}


	@Test
	void part1Test() {
		InputStream is = this.getClass().getResourceAsStream("input.txt");
		assertEquals("WSFTMRHPP", day5.part1(FileRead.readByLines(is)));
	}

	@Test
	void part2ExampleTest() {
		String input = """
				    [D]   \s
				[N] [C]   \s
				[Z] [M] [P]
				 1   2   3\s
				    
				move 1 from 2 to 1
				move 3 from 1 to 3
				move 2 from 2 to 1
				move 1 from 1 to 2""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals("MCD", day5.part2(FileRead.readByLines(is)));
	}

	@Test
	void part2Test() {
		InputStream is = this.getClass().getResourceAsStream("input.txt");
		assertEquals("GSLCMFBRP", day5.part2(FileRead.readByLines(is)));
	}

}