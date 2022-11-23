package greedy;

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
 * Sij, 标识包含从ai, 到aj的活动
 * 假设存在最优集合  Aij, 而 Ak是其中的一个元素
 * 则Aik = Aij ∩ Sik , Akj = Aij ∩ Skj
 * Aij = Aik ∪ Ak ∪ Akj
 * 则 Aij中最大兼容集合的个数等于 |Aij| = |Aik| + 1 + |Akj|
 * 但是需要判断是不是兼容活动，所以需要记录兼容子集合
 * 如果存在一个比 Aij 更好的兼容集合，Bij ,则
 * Bij = Bik ∩ Bk ∩ Bkj
 * 集合
 * 但是有一个前提就是，需要确定 Ak属于兼容子合， 和前面 和后面
 * 所以这里需要就需要保存，兼容子集合的，边界，这样只需要判断一次就够了
 */
public class ActivitySelector {

  public static int solution(int[] s, int[] f, int start, int n) {
    // 记录 集合内的，最大兼容子集合的元素数目
    int[][] aij = new int[s.length][s.length];
    // 记录集合内，最大兼容子集合的下标
    int[][] max = new int[s.length][s.length];
    for (int i = 0; i < s.length; i++) {
      aij[i][i] = 1;
      max[i][i] = i;
    }
    solutionAud(s, f, start, n, aij, max);
    int preIndex = 0;
    for (int i = start ; i <= n; i++) {
      if (max[start][i] > 0 && preIndex != max[start][i]) {
        System.out.printf(max[start][i] + ", ");
        preIndex = max[start][i];
      }
    }
    return aij[start][n];
  }

  private static int solutionAud(int[] s, int[] f, int i, int j, int[][] aij, int[][] max) {
    if (i == j) {
      return aij[i][j];
    }
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
      int left = solutionAud(s, f, i, leftCompatibleSetEndIndex, aij, max);
      int right = solutionAud(s, f, rightCompatibleSetStartIndex, j, aij, max);
      int total = left + right + 1;
      int index = k;
      if (right > 0) {
        index = max[rightCompatibleSetStartIndex][j];
      } else if (left > 0) {
        index = max[i][leftCompatibleSetEndIndex];
      }
      if (total > maxCompatibleSetCount) {
        maxCompatibleSetCount = total;
        maxCompatibleSetIndex = index;
      }
    }
    aij[i][j] = maxCompatibleSetCount;
    max[i][j] = maxCompatibleSetIndex;
//    System.out.printf("i: %s, j: %s, index: %s\n", i, j, maxCompatibleSetIndex);
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
