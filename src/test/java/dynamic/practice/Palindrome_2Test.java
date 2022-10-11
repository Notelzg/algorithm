package dynamic.practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Palindrome_2Test {

  @Test
  void testSolution() {
    String raw = "civic";
    assertEquals(raw, Palindrome_2.solution(raw, 0, raw.length() - 1));
    raw = "a";
    assertEquals(raw, Palindrome_2.solution(raw, 0, raw.length() - 1));
    raw = "chaca";
    assertEquals("ac", Palindrome_2.solution(raw, 0, raw.length() - 1));
  }

  @Test
  void testIsPalindrome() {
    assertTrue(Palindrome_2.isPalindrome("c"));
    assertFalse(Palindrome_2.isPalindrome(""));
    assertTrue(Palindrome_2.isPalindrome("civic"));
    assertTrue(Palindrome_2.isPalindrome("racecar"));
    assertTrue(Palindrome_2.isPalindrome("aibohphobia"));
    assertTrue(Palindrome_2.isPalindrome("carac"));
  }
}