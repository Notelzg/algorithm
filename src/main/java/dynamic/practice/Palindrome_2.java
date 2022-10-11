package dynamic.practice;

import java.util.Objects;

/**
 * 暴力解法，求所有子串，然后找到子串中最长回文子串
 * 时间复杂度是 2^(n-1)
 * 备忘方式只计算一遍，n3
 * 最长回文子序列
 * 1， 最优子结构
 * 假设存在最长回文子序列 expect[i][j]
 * 则其子序列 expect[i][k] 一定是最长子序列
 * 假如存在比 expect[i][k], 更长的子序列，expect[i',k] 则， expect[i',j] 大于expect[i][j]
 * 和假设矛盾，所以对该问题的求解，可以转为子问题的求解，来获取。
 * 如果expect[i][j] 是最长回文子序列
 * 存在两个现象
 * 如果 expect[j] == expect[i] ,同时 expect【j] = str[n]
 * 如果expect[j] ！= str[n] ,则
 * expect[i][j] = str[n-1]
 * 2, 递归公式
 * 1, expect[j] = str[n] ，且
 * expect[i][j] 是回文的, 如果不是回文的则继续向前找
 * expect[i][j] = expect[i][j-1]
 * 2, 如果不相等
 * 则 expect[i[j] = expect[i][j-1]
 * 3, 求解
 */
public class Palindrome_2 {
  /**
   * =
   *
   * @param str
   * @param left  开始下标，从0开始
   * @param right 结束下标， 长度-1
   * @return
   */
  public static String solution(String str, int left, int right) {
    if (Objects.isNull(str) || str.length() == 0) {
      return "";
    }
    if (left == right) {
      return String.valueOf(str.charAt(left));
    }
    String expect = str.substring(left, right + 1);
    if (isPalindrome(expect)) {
      return expect;
    }
    expect = "";
    for (int i = left + 1; i < right; i++) {
      String child = solution(str, i, right);
      if (expect.length() < child.length()) {
        expect = child;
      }
    }
    return expect;
  }

  public static boolean isPalindrome(String expect) {
    if (Objects.isNull(expect) || expect.length() == 0) {
      return false;
    }
    for (int i = 0; i < expect.length() / 2; i++) {
      if (expect.charAt(i) != expect.charAt(expect.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }
}
