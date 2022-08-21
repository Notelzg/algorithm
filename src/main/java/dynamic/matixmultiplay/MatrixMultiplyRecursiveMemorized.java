package dynamic.matixmultiplay;

import java.util.HashMap;
import java.util.Map;

/**
 * 矩阵链乘法 备忘录
 * 时间复杂度 O（n^2)
 * 由于纯粹的递归时间复杂度是 O(2^(n-1)) 指数级别的
 * 而纯粹的递归复杂度搞是因为，对于重叠的子会重复计算，导致
 * 所以这里使用备忘录模式，记录子问题的结果，
 * 这个时候复杂度的就算就依赖于递归调用的次数了，因为
 * 重复的调用是会直接返回答案的，不会进行计算了
 * 对于i，j ,范围是从1，到n
 * 所有的i，j的情况，就是 Cn2, O(n^2)个子问题
 * 因为所有的 T(i,j)都需要计算一次，每个都是一个子问题
 * 所以子问题,可以转为组合问题，即从n个数中，取出两个数
 * 由于是i必须小于j，所以适应组合排序，而不是全排序，
 * 共就是 c(n,2) = (n-2)!/2! = n(n-1)/2 => 规模是 n^2
 * 每个子问题的求解，总共需要 j-i次，才能求出最优解
 * j - i 的最大值是 n ,所以使用 n 代替
 * 所以总的时间复杂度： n^2 * n => n^3
 */
public class MatrixMultiplyRecursiveMemorized {

  /**
   * @param p 矩阵链数组，长度 n+1, p[0] 标识第一个矩阵的行，p[1] 第一个矩阵列， p[n] 最后一个矩阵的列
   * @param i 矩阵链开始下标, 从1开始, 如果从0开始，就不是矩阵了
   * @param j 矩阵链结束下标
   * @return
   */
  public static Map<String, Object> solution(int[] p, int i, int j) {
    int[][] expects = new int[p.length][p.length];
    int[][] cuts = new int[p.length][p.length];
    solutionAux(p, i, j, expects, cuts);
    System.out.println();
    StringBuffer sb = new StringBuffer(p.length);
    printResult(cuts, i, j, sb);
    Map<String, Object> result = new HashMap<>();
    result.put("expect", expects[i][j]);
    result.put("path", sb.toString());
    return result;
  }

  /**
   * cuts 记录了每个子问题的分割点，也就是添加括号的地方
   * 需要添加括号把分割点两边的子问题括起来，同时把整个问题括起来
   * 所以使用递归的方式处理
   * cuts[i][j] > 0 ,分别给左边加两个开始括号 ((
   * 中间分割点，加两个括号，)(
   * 最后添加 ））
   * 输出括号化的矩阵
   *
   * @param cuts
   */
  public static void printResult(int[][] cuts, int i, int j, StringBuffer sb) {
    if (i == j) {
      sb.append("A"+i);
      return;
    }
    sb.append("(");
    int k = cuts[i][j];
    printResult(cuts, i, k, sb);
    printResult(cuts, k + 1, j, sb);
    sb.append(")");
  }

  public static int solutionAux(int[] p, int i, int j, int[][] expects, int[][] cuts) {
    if (i == j) {
      return 0;
    }
    if (expects[i][j] > 0) {
      return expects[i][j];
    }
    int min = Integer.MAX_VALUE;
    for (int k = i; k < j; k++) {
      int expect = p[i - 1] * p[k] * p[j] + solutionAux(p, i, k, expects, cuts) +
          solutionAux(p, k + 1, j, expects, cuts);
      if (expect < min) {
        min = expect;
        cuts[i][j] = k;
      }
    }
    expects[i][j] = min;
    return min;
  }
}
