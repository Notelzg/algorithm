package greedy;

import org.junit.jupiter.api.Test;

class ActivitySelectorTest {

  @Test
  void solution() {
    int[] s = new int[]{0, 1, 3, 0, 5, 3, 5, 6,  8,  8,  2,  12};
    int[] f = new int[]{0, 4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};
//    System.out.println("\n" + ActivitySelector.solution(s, f, 0, 4));
    System.out.println("\n" + ActivitySelector.solution(s, f, 1, 8));
    System.out.println("\n" + ActivitySelector.solution(s, f, 1, s.length-1));
  }
}