package greedy;

import dynamic.matixmultiplay.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 活动选择问题，贪心解法
 * 比起动态规划解法简单了很多
 * 因为对于活动类选择问题，有一个定理可以使用
 * 对于活动集合Sij, Si如果是最早结束的活动
 * 则其一定是最优解的最左边的那一部分，可以直接把动态规划对比计算的那一步
 * 优化掉，直接确定Ak左边的最优子结构，从而只需要计算另外一部分。
 * 如果Sij是按照，结束时间升序排序的话, Si就是最优子结构。
 * 定理证明
 * 如果Sij存在最大的兼容子集合  Aij
 * 如果其最早结束的活动是 Si，则证明定理正确。
 * 如果其最早结束的活动是 Sm, 因为Si是Sij中最早结束的活动
 * 所以  Si的结束时间，肯定小于 Sm，同时Sm最早开始的活动，
 * 所以完全可以把Sm用Si替换，在最大兼容子集合中
 * 替换之后Si和其他元素肯定也是兼容的。
 * 所以可以证明定理的真确性。
 */
public class GreedyActivitySelector {
  /**
   * @param s     活动开始时间数组
   * @param f     活动结束时间数组, 活动按照结束时间升序排序
   * @param start 开始的下标
   * @param n     , 元素的个数，规模
   * @return
   */
  public static Result solution(int[] s, int[] f, int start, int n) {
    List<Integer> exp = new ArrayList<>();
    exp.add(start);
    int preCompatibleSetIndex = start;
    for (int i = start + 1; i < n; i++) {
      // 向后找和Si 兼容的子集合, 并且添加到兼容子集合
      if (s[i] >= f[preCompatibleSetIndex]) {
        exp.add(i);
        preCompatibleSetIndex = i;
      }
    }
   return new Result(exp.size(), exp.stream().map(i->"a"+i).collect(Collectors.joining(",")));
  }
}
