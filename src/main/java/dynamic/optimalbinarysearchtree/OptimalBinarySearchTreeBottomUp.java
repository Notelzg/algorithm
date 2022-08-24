package dynamic.optimalbinarysearchtree;

import dynamic.matixmultiplay.Result;

/**
 * 最优二叉搜索树， 非递归，自底向上
 */
public class OptimalBinarySearchTreeBottomUp {
  public static Result solution(int[] p, int[] q, int i, int j) {
    int[][] expects = new int[q.length + 1][q.length + 1];
    int[][] wij = new int[q.length + 1][q.length + 1];
    int[][] root = new int[q.length + 1][q.length + 1];
    for (int k = i; k <= j + 1; k++) {
      expects[k][k - 1] = q[k - 1];
      wij[k][k - 1] = q[k - 1];
    }

    for (int l = 1; l <= j; l++) {
      for (int ki = i; ki <= j - l + 1; ki++) {
        int kj = ki + l - 1;
        expects[ki][kj] = Integer.MAX_VALUE;
        wij[ki][kj] = wij[ki][kj - 1] + q[kj] + p[kj];
        for (int k = ki; k <= kj; k++) {
          int expect = expects[ki][k - 1] + expects[k + 1][kj] + wij[ki][kj];
          if (expect < expects[ki][kj]) {
            expects[ki][kj] = expect;
            root[ki][kj] = k;
          }
        }
      }
    }
    return new Result(expects[i][j], "a");
  }
}
