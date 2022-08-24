package dynamic.optimalbinarysearchtree;

import dynamic.matixmultiplay.Result;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptimalBinarySearchTreeBottomUpTest {
  @Test
  void solutionTest() {
    int[] k = new int[]{1,2,3,4,5};
    int[] p = new int[]{0, 15, 10, 05, 10, 20};
    int[] q = new int[]{5, 10, 05, 05, 05, 10};
    Result result = OptimalBinarySearchTreeBottomUp.solution(p, q, 1, 5);
    System.out.println(result);
    assertEquals(275, result.getExpect());
  }
}