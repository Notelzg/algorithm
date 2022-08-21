package dynamic.lcs;

import dynamic.matixmultiplay.Result;

/**
 * 最长不连续公共子列，递归算法
 * 暴力解法，
 * 时间复杂度 2^n
 * 1， 刻画子问题结构
 * 一个字符串，的所有子串有 2^n种情况
 * 拿到所有的子串，去另外一个字符串进行匹配，找到其中最大的那个子串
 * 如何进行匹配了，从第一个字符串，或者从最后一个字符串开始匹配，找到一个，找下一个
 * 如果都能找到则匹配，则属于公关子序列，否则是非公关子序列。
 * 公共子序列的特点是什么呢？
 * 是要两个字符串中都有一个相同的元素
 * 比如 字符串 X(x1,x2,..xm) , 字符串 Y(y1, y2, ,..,yn)
 * 假如存在公共子串 Z(z1, z2,...zk)
 * 则条件：zk == xi && zk == yj 一定成功， 否则则不是公共子串和假设矛盾。
 * 这个条件成立的清下下，如果找到，xi == yj 就是关键点，
 * 方式1， 使用从后向前找的方式
 * 如果 xm==yn ,则 zk=xm
 * 如 xm！=yn ，则存在两种情况
 * 就需要 m-1， 或者n-1， 向前找，公共子序列，所以存在两种情况,
 * 如果 m-1 没有，继续这个过程。到这里是不是突然发现这个问题可以拆成子问题了
 * 一个大的问题，变成了一个小的问题，最后想只有一个元素的时候，是一定有解的。
 * 所以最优子结构来了
 * 回到最优子序列的问题，全面是找到的子序列，如果想找最优子序列
 * 如果xm==yn， 则把zk追加到当前最长的公共子序列中即可,然后找继续找下一，xm-1,yn-1,同时向前移动
 * 否则， 则从 xm-1,yn  或者 xm，yn-1中，寻找
 * 这样就把问题，拆解成最优子问题了
 *
 * <p>
 * 2， 递归公式
 * 1, 如果， xm==yn , zk==xm, recursive(xm-1, yn-1)
 * 2, xm!=yn ,则 zk=recursive(xm-1,y) 或者 zk=resursive(xm, yn-1)
 * 3， 计算最优值
 *   字符串的特殊性，直接输出了。
 * 4， 输出最优解
 * 最优解直接输出了
 */
public class LCSRecursive {
  /**
   * 这种属于暴力解法
   * 注意这里的最长公共子串，不一定只有一个，可能有多个子串，长度一样
   * 这里只能输出其中的一种情况，比如这里 BCBA也是最长公共子串
   *  这个主要是屈取决于输入的字符串，是否存在唯一的最长公共子串
   * @param x
   * @param xi  字符串 x的当前的下标
   * @param y
   * @param yi  ,字符串 y的下标
   * @return
   */
  public static String solution(String x, int xi, String y, int yi) {
    if (x.length() == 0 || y.length() == 0) {
      return "";
    }
    // 数组下标0，有值
    if (xi < 0 || yi < 0) {
      return "";
    }
    if (x.charAt(xi) == y.charAt(yi)) {
      return solution(x, xi - 1, y, yi - 1) + x.charAt(xi);
    }
    String xSub = solution(x, xi - 1, y, yi);
    String ySub = solution(x, xi, y, yi - 1);
    // 如果最长公共子串不唯一，这里的判断只会取其中的一个
    if (xSub.length() > ySub.length()) {
      return xSub;
    } else {
      return ySub;
    }
  }

}
