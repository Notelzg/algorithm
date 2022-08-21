package dynamic.matixmultiplay;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static dynamic.matixmultiplay.MatrixMultiplyBottomUp.solution;
import static org.junit.jupiter.api.Assertions.*;

class MatrixMultiplyBottomUpTest {

  @Test
  public void solutionTest() {
    int[] p = new int[]{30, 35, 15, 5, 10, 20, 25};
    Result result = solution(p);
    assertEquals(15125, result.getExpect());
    assertEquals("((A1(A2A3))((A4A5)A6))", result.getPath());
  }
}