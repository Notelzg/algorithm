package dynamic.lcs;

import dynamic.matixmultiplay.Result;

/**
 * 自底向上解法
 * 非递归
 */
public class LCSBottomUp {

  public static Result solution(String x, String y) {
    int[][] expects = new int[x.length() + 1][y.length() + 1];
    int[][] paths = new int[x.length() + 1][y.length() + 1];
    // 如果i从0开始，则 0-1是-1，数组会越界，所以这里从1开始，标识数组长度
    for (int i = 1; i <= x.length(); i++) {
      // 从1开始，标识数组长度
      for (int j = 1; j <= y.length(); j++) {
        if (x.charAt(i - 1) == y.charAt(j - 1)) {
          expects[i][j] = expects[i - 1][j - 1] + 1;
          paths[i][j] = x.charAt(i - 1);
          continue;
        }
        int xSub = expects[i - 1][j];
        int ySub = expects[i][j - 1];
        if (xSub >= ySub) {
          paths[i][j] = -1;
          expects[i][j] = xSub;
        } else {
          paths[i][j] = 1;
          expects[i][j] = ySub;
        }
      }
    }
    StringBuffer sb = new StringBuffer();
    lcsPath(paths, x.length(), y.length(), x, sb);
    return new Result(expects[x.length()][y.length()], sb.toString());
  }

  public static void lcsPath(int[][] paths, int xi, int yi, String x, StringBuffer sb) {
    if (xi == 0 || yi == 0) {
      return;
    }

    if (paths[xi][yi] > 1) {
      lcsPath(paths, xi - 1, yi - 1, x, sb);
      // 由于记录下标的时候，增加了1， 所以这里要减去1
      sb.append(x.charAt(xi-1));
      return;
    }
    if (paths[xi][yi] == -1) {
      lcsPath(paths, xi - 1, yi, x, sb);
      return;
    }
    lcsPath(paths, xi, yi - 1, x, sb);
  }
}
