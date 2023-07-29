package interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlgoTest {

  @Test
  void solution() {
//    Assertions.assertEquals(Algo.solution(););
  }

  /**
   * 题目一：
   * 给定一个数组，实现快速排序让数组有序
   * 快速排序的思想，是什么，是每次最终确认一个元素的位置
   * 通过判断一个元素，左边都是小于的元素，右边都是大于的元素
   * 确定好一个元素的位置之后，通过递归，进行排序？
   *
   * @param nums
   */
  public static void sort(int[] nums) {
    if (null == nums || nums.length == 1) {
      return;
    }
    int temp = nums[0];
    int leftIndex = 1;
    int rightIndex = nums.length - 1;
    while (leftIndex < rightIndex) {
      // 和右边的对比，比他小的不动，大的换位
      while (rightIndex > 0 && nums[rightIndex] > temp) {
        rightIndex--;
      }

      // 和左边的对比，比他小的不动，大的换位
      while (leftIndex < nums.length-1 && nums[leftIndex] < temp) {
        leftIndex++;
      }
//      nums[leftIndex]

    }
  }

  public static void swap(int[] nums, int form, int to) {
    int temp = nums[form];
    nums[form] = nums[to];
    nums[to] = temp;
  }
}