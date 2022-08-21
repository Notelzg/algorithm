package dynamic.matixmultiplay;

import org.junit.jupiter.api.Test;

import static dynamic.matixmultiplay.MatrixMultiplyRecursive.solution;
import static org.junit.jupiter.api.Assertions.*;

class MatrixMultiplyRecursiveTest {

  @Test
  public void solutionTest() {
    int[] p = new int[]{30, 35, 15, 5, 10, 20, 25};
    assertEquals(0, solution(p, 1, 1));
    assertEquals(p[0]*p[1]*p[2], solution(p, 1, 2));
    assertEquals(7875, solution(p, 1, 3));
    assertEquals(15125, solution(p, 1, 6));
  }
}