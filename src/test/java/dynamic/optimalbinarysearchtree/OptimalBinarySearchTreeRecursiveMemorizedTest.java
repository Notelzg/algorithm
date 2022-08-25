package dynamic.optimalbinarysearchtree;

import dynamic.matixmultiplay.Result;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptimalBinarySearchTreeRecursiveMemorizedTest {
  @Test
  void solutionTest() {
    int[] k = new int[]{1, 2, 3, 4, 5};
    int[] p = new int[]{0, 15, 10, 05, 10, 20};
    int[] q = new int[]{5, 10, 05, 05, 05, 10};
    Result result = OptimalBinarySearchTreeRecursiveMemorized.solution(p, q, 1, 5);
    System.out.println(result);
    assertEquals(275, result.getExpect());
    assertEquals("D0,D1,K1,D2,D3,K3,D4,K4,D5,K5,K2", result.getPath());
  }

  @Test
  void solutionTest_15_5_2() {
    int[] p = new int[]{0, 4, 6, 8, 2, 10, 12, 14};
    int[] q = new int[]{6, 6, 6, 6, 5, 5, 5, 5};
    Result result = OptimalBinarySearchTreeRecursiveMemorized.solution(p, q, 1, 7);
    assertEquals(312, result.getExpect());
    assertEquals("D0,D1,K1,D2,D3,D4,K4,K3,K2,D5,D6,K6,D7,K7,K5", result.getPath());

  }
}