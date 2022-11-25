package greedy;

import dynamic.matixmultiplay.Result;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ActivitySelectorTest {

  @Test
  void solution() {
    // 下标为0，使用0填充，是为了方便计算最优解的值，可以看最优解第四步分析
    int[] s = new int[]{0, 1, 3, 0, 5, 3, 5, 6,  8,  8,  2,  12};
    int[] f = new int[]{0, 4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};
    Result result = ActivitySelector.solution(s, f, 1, s.length-1);
    assertEquals(4, result.getExpect());
    assertEquals("a1,a4,a8,a11,", result.getPath());
  }
}