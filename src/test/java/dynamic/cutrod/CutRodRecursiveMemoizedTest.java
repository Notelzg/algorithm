package dynamic.cutrod;

import org.junit.jupiter.api.Test;

import static dynamic.cutrod.CutRodRecursiveMemoized.solution;
import static org.junit.jupiter.api.Assertions.*;

class CutRodRecursiveMemoizedTest {
  @Test
  void solutionTest() {
    int[] prices = new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
    assertEquals(1, solution(1, prices));
    assertEquals(5, solution(2, prices));
    assertEquals(8, solution(3, prices));
    assertEquals(10, solution(4, prices));
    assertEquals(13, solution(5, prices));
    assertEquals(17, solution(6, prices));
    assertEquals(18, solution(7, prices));
    assertEquals(22, solution(8, prices));
    assertEquals(25, solution(9, prices));
    assertEquals(30, solution(10, prices));
  }

}