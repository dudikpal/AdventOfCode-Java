package year2015.day4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static org.junit.jupiter.api.Assertions.*;

class Day4Test {
  
  private static Day4 day4;
  private static MessageDigest md;
  private final static String INPUT = "bgvyzdsv";
  
  @BeforeAll
  static void setUp() {
    day4 = new Day4();
    try {
      md = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    
  }
  
  @Test
  void part1Example() {
    
    long solution = 609043;
  
    assertEquals(solution, day4.part1("abcdef", "00000"));
  }
  
  @Test
  void part1() {
    long solution = 254575;
    
    assertEquals(solution, day4.part1(INPUT, "00000"));
  }
  
  @Test
  void part2() {
    long solution = 1038736;
    
    assertEquals(solution, day4.part1(INPUT, "000000"));
  }
}