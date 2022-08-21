package dynamic.matixmultiplay;

import java.util.Map;

/**
 * 矩阵链括号化最优解
 * 非递归，自底向上
 */
public class MatrixMultiplyBottomUp {
  public static Result solution(int[] p) {
    if (null == p || p.length == 0) {
      return new Result(0, null);
    }
    int n = p.length - 1;
    int[][] expects = new int[n+1][n+1];
    int[][] cuts = new int[n+1][n+1];
    // 标识，矩阵链的长度, 等于1的时候，都是0，不需要处理
    for (int l = 2; l <= n; l++) {
      // 计算所有相同长度的所有矩阵链
      // 如果不加1，会导致，最后一个算不到
      for (int i = 1; i <= n- l + 1; i++) {
        int min = Integer.MAX_VALUE;
        // 如果不减1，计算的元素个数就是l+1个，
        // 比如：l = 2, i = 1, j = i+l = 3, 1,3子链，长度就是3了，而不是2了，所以需要减去1
        // 主要是因为数组的长度，即数组元素的格式=结束下标-开始下标 + 1，所以这里需要减去1，
        // 从数组的长度，转为相应的下标，所有的数组长度和下标转化都需要这样处理
        int j = i + l -1 ;
        // 分割点，就是从i到j-1
        for (int k = i; k < j; k++) {
          int t = p[i - 1] * p[k] * p[j] + expects[i][k] + expects[k + 1][j];
          if (t < min) {
            min = t;
            cuts[i][j] = k;
          }
        }
        expects[i][j] = min;
      }
    }
    StringBuffer path = new StringBuffer();
    MatrixMultiplyRecursiveMemorized.printResult(cuts, 1, n, path);
    return new Result(expects[1][n], path.toString());
  }
}
