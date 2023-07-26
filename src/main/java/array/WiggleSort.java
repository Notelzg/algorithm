package array;

import java.util.Arrays;

/**
 * 摆动排序
 */
public class WiggleSort {
  /**
   * 给你一个的整数数组 nums, 将该数组重新排序后使 nums[0] <= nums[1] >= nums[2] <= nums[3]...
   * <p>
   * 输入数组总是有一个有效的答案。
   * <p>
   * <p>
   * <p>
   * 示例 1:
   * <p>
   * 输入：nums = [3,5,2,1,6,4]
   * 输出：[3,5,1,6,2,4]
   * 解释：[1,6,2,5,3,4]也是有效的答案
   * 示例 2:
   * <p>
   * 输入：nums = [6,6,5,6,3,8]
   * 输出：[6,6,5,6,3,8]
   * <p>
   * <p>
   * 提示：
   * <p>
   * 1 <= nums.length <= 5 * 104
   * 0 <= nums[i] <= 104
   * 输入的 nums 保证至少有一个答案。
   **/
  // 暴力解法，就是先排队，后进行交换
  public static void wiggleSort(int[] nums) {
    Arrays.sort(nums);
    for (int i = 2; i < nums.length; i += 2) {
      swap(nums, i, i - 1);
    }

  }


  // 优化解法 nums[0] <= nums[1] >= nums[2] <= nums[3]..
  // O(n)
  public static void wiggleSortOpt(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      if (i % 2 == 0) {
        if (nums[i] > nums[i - 1]) {
          swap(nums, i, i - 1);
          // 不需要进行递归了，因为本身就是符合规律的
          // i >= i-1
          // i <= i-1
          // 通过交换的规律我们知道， 交换后，a > b > c ,交换 b 和 c ≈还是大于 a，所以不需要递归去处理
          //  3 5 6 , 5 < 6 不符合规则，5 和 6 交换之后， 6 还是大于 3， 所以不需要进行递归
//        sortAux(nums, i - 1);
        }
      } else {
        if (nums[i] < nums[i - 1]) {
          swap(nums, i, i - 1);
          // 一样的道理
//        sortAux(nums, i - 1);
        }
      }

    }
  }

  public static void swap(int[] nums, int from, int to) {
    int temp = nums[from];
    nums[from] = nums[to];
    nums[to] = temp;
  }

  /*
   *
   *
   * 进阶：你能在 O(n) 时间复杂度下解决这个问题吗？
   */

}
