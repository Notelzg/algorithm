package dynamic.optimalbinarysearchtree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptimalBinarySearchTreeRecursiveTest {

  @Test
  void solutionTest() {
    int[] k = new int[]{1,2,3,4,5};
    double[] p = new double[]{0, 0.15, 0.10, 0.05, 0.10, 0.20};
    double[] q = new double[]{0.05, 0.10, 0.05, 0.05, 0.05, 0.10};
    assertEquals(2.75d, OptimalBinarySearchTreeRecursive.solution(p, q, 1, 5));
  }
}