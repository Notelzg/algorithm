package dynamic.lcs;

import dynamic.matixmultiplay.Result;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LCSRecursiveMemorizedTest {

  @Test
  void solutionTest() {
    String x = "ABCBDAB";
    String y = "BDCABA";
    Result result = LCSRecursiveMemorized.solution(x, y);
    assertEquals(4, result.getExpect());
    assertEquals("BCBA", result.getPath());
  }
}