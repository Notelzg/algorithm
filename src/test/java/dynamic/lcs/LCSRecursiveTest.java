package dynamic.lcs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LCSRecursiveTest {

  @Test
  void solutionTest() {
    String x = "ABCBDAB";
    String y = "BDCABA";
    String lcs = LCSRecursive.solution(x, x.length()-1, y, y.length()-1);
    assertEquals("BDAB", lcs);
  }
}