package dynamic.lcs;

import dynamic.matixmultiplay.Result;

/**
 * 带备忘录的递归方法
 * 时间复杂度 O(m*n)
 * 因为子问题，只会计算一遍
 * 对于 x 子问题空间有 m个
 * y 子问题空间有，n个
 * 所有总共有 m*n个，
 * 每个子问题的处理，时间复杂度是O(1)
 * 因为子问题，就是进行对比，只存在一种可能
 * 因为只有对比操作，没有其他操作
 */
public class LCSRecursiveMemorized {
  /**
   * 由于需要记录子问题，这里记录什么呢？
   * 两个方式
   * 1， 子问题的lcs长度， 子问题中相等的元素下标
   * expects[i,j] 记录lcs长度
   * paths[i, j] 记录公共子串元素
   * 2， 子问题的最长公共子串lcs， 需要占用更多的内存空间，以为会重复记录公共子串
   * 书上写的是方式1，先用方式1
   * 再用方式2
   *
   * @param x
   * @param y
   * @return
   */
  public static Result solution(String x, String y) {
    int[][] expects = new int[x.length()][y.length()];
    int[][] paths = new int[x.length()][y.length()];
    solutionAux(x, x.length() - 1, y, y.length() - 1, expects, paths);
    StringBuffer sb = new StringBuffer();
    lcsPath(paths, x.length() - 1, y.length() - 1, x, sb);
    return new Result(expects[x.length() - 1][y.length() - 1], sb.toString());
  }

  public static String lcsPath(int[][] paths, int xi, int yi, String x, StringBuffer sb) {
    if (xi < 0 || yi < 0) {
      return "";
    }
    if (paths[xi][yi] > 1) {
      lcsPath(paths, xi - 1, yi - 1, x, sb);
      sb.append(x.charAt(xi));
      return sb.toString();
    }
    if (paths[xi][yi] == -1) {
      return lcsPath(paths, xi - 1, yi, x, sb);
    }
    if (paths[xi][yi] == 1) {
      return lcsPath(paths, xi, yi - 1, x, sb);
    }
    return "";
  }

  private static int solutionAux(String x, int xi, String y, int yi, int[][] expects, int[][] paths) {
    if (xi < 0 || yi < 0) {
      return 0;
    }
    if (expects[xi][yi] > 0) {
      return expects[xi][yi];
    }
    if (x.charAt(xi) == y.charAt(yi)) {
      paths[xi][yi] = x.charAt(xi);
      expects[xi][yi] = solutionAux(x, xi - 1, y, yi - 1, expects, paths) + 1;
      return expects[xi][yi];
    }
    int xSub = solutionAux(x, xi - 1, y, yi, expects, paths);
    int ySub = solutionAux(x, xi, y, yi - 1, expects, paths);
    if (xSub >= ySub) {
      paths[xi][yi] = -1;
      expects[xi][yi] = xSub;
    } else {
      paths[xi][yi] = 1;
      expects[xi][yi] = xSub;
      expects[xi][yi] = ySub;
    }
    return expects[xi][yi];
  }
}
