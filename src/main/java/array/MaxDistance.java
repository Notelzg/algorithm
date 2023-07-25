package array;

import java.util.List;

/**
 * 给定 m 个数组，每个数组都已经按照升序排好序了。现在你需要从两个不同的数组中选择两个整数（每个数组选一个）
 * 并且计算它们的距离。两个整数 a 和 b 之间的距离定义为它们差的绝对值 |a-b| 。你的任务就是去找到最大距离
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [[1,2,3],
 * [4,5],
 * [1,2,3]]
 * 输出： 4
 * 解释：
 * 一种得到答案 4 的方法是从第一个数组或者第三个数组中选择 1，同时从第二个数组中选择 5 。
 * <p>
 * <p>
 * 注意：
 * <p>
 * 每个给定数组至少会有 1 个数字。列表中至少有两个非空数组。
 * 所有 m 个数组中的数字总数目在范围 [2, 10000] 内。
 * m 个数组中所有整数的范围在 [-10000, 10000] 内。
 */
public class MaxDistance {
  /**
   * 暴力解法，使用动态规划
   *
   * @param arrays
   * @return
   */
  public static int maxDistance(List<List<Integer>> arrays) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arrays.size(); i++) {
      if (arrays.get(i).isEmpty()) {
        continue;
      }
      for (int j = i + 1; j < arrays.size(); j++) {
        if (arrays.get(j).isEmpty()) {
          continue;
        }
        int iMin = arrays.get(i).get(0);
        int iMax = arrays.get(i).size() == 1 ? arrays.get(i).get(0) : arrays.get(i).get(arrays.get(i).size() - 1);
        int jMin = arrays.get(j).get(0);
        int jMax = arrays.get(j).size() == 1 ? arrays.get(j).get(0) : arrays.get(j).get(arrays.get(j).size() - 1);
        int ijMax = Math.max(Math.abs(iMin - jMax), Math.abs(iMax - jMin));
        max = Math.max(ijMax, max);
      }
    }
    return max;
  }

  /**
   * 暴力解法的时间复杂度是 n^2
   * 使用动态规划的思想有点走不通了，动态规划也需要遍历所有可能
   * 所以换一种思路，每次只获取0， i，中最小，最大值，然后和当前的对比
   * 这次只需要 O(n) 的时间复杂度
   */
  public static int maxDistanceMem(List<List<Integer>> arrays) {
    int maxDistance = Integer.MIN_VALUE;
    int min = arrays.get(0).get(0);
    int max = arrays.get(0).get(arrays.get(0).size() - 1);
    for (int i = 1; i < arrays.size(); i++) {
      if (arrays.get(i).isEmpty()) {
        continue;
      }
      int iMin = arrays.get(i).get(0);
      int iMax = arrays.get(i).get(arrays.get(i).size() - 1);
      int iMaxDistance = Math.max(Math.abs(max - iMin), Math.abs(iMax - min));
      if (iMaxDistance > maxDistance) {
        maxDistance = iMaxDistance;
        min = iMin < min ? iMin : min;
        max = iMax > max ? iMax : max;
      }
    }
    return maxDistance;
  }

}
