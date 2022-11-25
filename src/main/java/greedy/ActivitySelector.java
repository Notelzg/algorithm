package greedy;

import dynamic.matixmultiplay.Result;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 竞争共享资源的多个活动问题，目标是选出一个最大的互相兼容的活动集合
 * 假定有一个n个活动的集合S={a1, a2,...an}, 这些活动使用同一个资源
 * （例如阶梯教室），而这个资源再某个时刻只能供一个活动使用。每个活动
 * ai,都有一个开始时间 si，一个结束时间 fi, 其中 0 《= si  < fi < 无穷大
 * 如果被选中，任务ai发生在半开时间区间 [si, fi). 如果两个活动ai 和 aj
 * 满足 【si, fi) [sj, fj) 不重叠，则称他们是兼容的。也就是说 若 si>=fj
 * 或者 sj >= fi, 则ai 和 aj是兼容的。在活动选择问题中，我们希望选出一个
 * 最大兼容活动集合。假定活动已经按照结束时间的单调递增顺序排序：
 * f1 <= f2 <= f3 .. <= fn.
 * 使用动态规划来处理
 * 第一步，构造最优子结构。
 * Sij, 标识从ai结束之后开始的活动, 到aj开始之前的结束活动的集合，这里要注意的是 ai, aj  和 Sij是完全兼容的，
 * 假设存在最优集合  Aij, 而 Ak是其中的一个元素, 如果ak是最优解的一个兼容元素，则ak一定和Sik, Skj 兼容
 * 注意1：ak，可能和 ak-1是不兼容的，所以Sik不包含ak-1, 而是从ak开始，向前找到一个结束时间小于等于ak结束时间的第一个活动，
 * 注意2：ak，可能和 ak+1是不兼容的，所以Skj不包含ak+1, 而是从ak开始，找到一个开始时间大于等于ai结束时间的第一个活动，
 * 则Aik = Aij ∩ Sik , Akj = Aij ∩ Skj
 * Aij = Aik ∪ Ak ∪ Akj
 * 则 Aij中最大兼容集合的个数等于 |Aij| = |Aik| + 1 + |Akj|
 * 但是需要判断是不是兼容活动，所以需要记录兼容子集合
 * 如果存在一个比 Aij 更好的兼容集合，Bij ,则
 * Bij = Bik ∩ Bk ∩ Bkj
 * 集合
 * 但是有一个前提就是，需要确定 Ak属于兼容子合， 和前面 和后面
 * 所以这里需要就需要保存，兼容子集合的，边界，这样只需要判断一次就够了
 * 第二步，构造递归公式
 * Aij = 0 (i <j)
 * Aij = 1 (i == j)
 * Aij = Math.max(Aik + 1 + Akj) k ∈（i...j)
 * 第三步计算最优值
 * 主要难点就是，关于Sij的定义，一定要是 Si结束后开始，也就是和Si本身兼容，Si开始之前结束，和Sj也兼容。
 * 第四步构造最优解
 * 使用 compatibleSet[][]
 * 记录Sij集合中，最大兼容子集的，最大的下标，因为小的兼容子集合，肯定是属于更大的兼容子集合的
 * 所以不需要每个集合都重复记录兼容字集合。
 * 最后只需要遍历从i，到j中，其下标大于0的，就是兼容子集合了。
 * 由于数组下标都是从0开始，所以这里使用把0填充一下，否则无法区分0是兼容下标，还是不是，需要单独加判断逻辑，
 * 使用填充法就比较简单的解决了这个问题。
 */
public class ActivitySelector {

  public static Result solution(int[] s, int[] f, int start, int n) {
    // 记录 集合内的，最大兼容子集合的元素数目
    int[][] aij = new int[s.length][s.length];
    // 记录集合内，最大兼容子集合的下标
    int[][] compatibleSet = new int[s.length][s.length];
    for (int i = 0; i < s.length; i++) {
      // 只有一个活动的时候，本身肯定是兼容，其本身下标，就是兼容集合。
      aij[i][i] = 1;
      compatibleSet[i][i] = i;
    }
    solutionAud(s, f, start, n, aij, compatibleSet);
    int preIndex = 0;
    StringBuilder sb = new StringBuilder();
    for (int i = start; i <= n; i++) {
      if (compatibleSet[start][i] > 0 && preIndex != compatibleSet[start][i]) {
        sb.append("a" + compatibleSet[start][i] + ",");
        preIndex = compatibleSet[start][i];
      }
    }
    return new Result(aij[start][n], sb.toString());
  }

  private static int solutionAud(int[] s, int[] f, int i, int j, int[][] aij, int[][] max) {
    if (i > j) {
      return 0;
    }
    if (aij[i][j] > 0) {
      return aij[i][j];
    }
    // 由于使用k作为分割点，需要验证k是不是，左边集合 和 右边结合的兼容子集合
    // 如果 k 等于 i 则，肯定不行，这里k 等于
    int maxCompatibleSetCount = 0;
    int maxCompatibleSetIndex = 0;
    for (int k = i; k <= j; k++) {
      int leftCompatibleSetEndIndex = getLeftCompatibleSetEndIndex(s, f, k, i);
      int rightCompatibleSetStartIndex = getRightCompatibleSetEndIndex(s, f, k, j);
      int aik = solutionAud(s, f, i, leftCompatibleSetEndIndex, aij, max);
      int akj = solutionAud(s, f, rightCompatibleSetStartIndex, j, aij, max);
      int compatibleSetCount = aik + akj + 1;
      // 由于ak和 Sik, Skj兼容，所以作为默认值完全没有问题，只有Akj存在，才需要功能新。
      int compatibleSetIndex = k;
      if (akj > 0) {
        compatibleSetIndex = max[rightCompatibleSetStartIndex][j];
      }
      if (compatibleSetCount > maxCompatibleSetCount) {
        maxCompatibleSetCount = compatibleSetCount;
        maxCompatibleSetIndex = compatibleSetIndex;
      }
    }
    aij[i][j] = maxCompatibleSetCount;
    max[i][j] = maxCompatibleSetIndex;
    return maxCompatibleSetCount;
  }

  // 开始时间大于k的结束时间，寻找 Skj
  private static int getRightCompatibleSetEndIndex(int[] s, int[] f, int k, int j) {
    for (int index = k + 1; index <= j; index++) {
      if (s[index] >= f[k]) {
        return index;
      }
    }
    return Integer.MAX_VALUE;
  }

  // 结束时间小于k的开始时间，寻找 Sik
  private static int getLeftCompatibleSetEndIndex(int[] s, int[] f, int k, int i) {
    for (int index = k - 1; index >= i; index--) {
      if (f[index] <= s[k]) {
        return index;
      }
    }
    return Integer.MIN_VALUE;
  }
}
