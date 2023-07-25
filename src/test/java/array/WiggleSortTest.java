package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class WiggleSortTest {

  @Test
  public  void wiggleSortOpt() {
//       * 输入：nums = [3,5,2,1,6,4]
//   * 输出：[3,5,1,6,2,4]
//   * 解释：[1,6,2,5,3,4]也是有效的答案
    int[]  nums = new int[]{3,5,2,1,6,4};
    int[]  expect1 = new int[]{3,5,1,6,2,4};
    WiggleSort.wiggleSortOpt(nums);
    System.out.println(Arrays.toString(nums));
    Assertions.assertTrue(Arrays.equals(expect1, nums));

  }

  @Test
  public  void wiggleSort() {
//       * 输入：nums = [3,5,2,1,6,4]
//   * 输出：[3,5,1,6,2,4]
//   * 解释：[1,6,2,5,3,4]也是有效的答案
    int[]  nums = new int[]{3,5,2,1,6,4};
    int[]  expect1 = new int[]{1, 3, 2, 5, 4, 6};
    WiggleSort.wiggleSort(nums);
    System.out.println(Arrays.toString(nums));
    Assertions.assertTrue(Arrays.equals(expect1, nums));

  }
}