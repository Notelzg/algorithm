package dynamic.matixmultiplay;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static dynamic.matixmultiplay.MatrixMultiplyRecursiveMemorized.solution;
import static org.junit.jupiter.api.Assertions.*;

class MatrixMultiplyRecursiveMemorizedTest {

  @Test
  public void solutionTest() {
    int[] p = new int[]{30, 35, 15, 5, 10, 20, 25};
    Map<String, Object> result = solution(p, 1, 6);
    assertEquals(15125, result.get("expect"));
    assertEquals("((A1(A2A3))((A4A5)A6))", result.get("path"));
  }
}