package year2017.day7;

import org.junit.jupiter.api.Test;
import utils.FileRead;
import year2017.day6.Day6;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Day7Test {

	private Day7 day7 = new Day7();

	@Test
	void part1Example1Test() {
		String input = """
				pbga (66)
				xhth (57)
				ebii (61)
				havc (66)
				ktlj (57)
				fwft (72) -> ktlj, cntj, xhth
				qoyq (66)
				padx (45) -> pbga, havc, qoyq
				tknk (41) -> ugml, padx, fwft
				jptl (61)
				ugml (68) -> gyxo, ebii, jptl
				gyxo (61)
				cntj (57)""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals("tknk", day7.part1(FileRead.readByLines(is)));
	}

	@Test
	void part1Test() {
		InputStream is = this.getClass().getResourceAsStream("input.txt");
		assertEquals("hlqnsbe", day7.part1(FileRead.readByLines(is)));
	}

	@Test
	void part2Example1Test() {
		String input = """
				pbga (66)
				xhth (57)
				ebii (61)
				havc (66)
				ktlj (57)
				fwft (72) -> ktlj, cntj, xhth
				qoyq (66)
				padx (45) -> pbga, havc, qoyq
				tknk (41) -> ugml, padx, fwft
				jptl (61)
				ugml (68) -> gyxo, ebii, jptl
				gyxo (61)
				cntj (57)""";
		InputStream is = new ByteArrayInputStream(String.join(System.lineSeparator(), Arrays.asList(input)).getBytes(StandardCharsets.UTF_8));
		assertEquals(0, day7.part2(FileRead.readByLines(is)));
	}

	@Test
	void part2Test() {
		InputStream is = this.getClass().getResourceAsStream("input.txt");
		assertEquals("hlqnsbe", day7.part2(FileRead.readByLines(is)));
	}
}