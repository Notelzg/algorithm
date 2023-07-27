package array;

/**
 * 易混淆数
 * 给定一个数字 N，当它满足以下条件的时候返回 true：
 * <p>
 * 原数字旋转 180° 以后可以得到新的数字。
 * <p>
 * 如 0, 1, 6, 8, 9 旋转 180° 以后，得到了新的数字 0, 1, 9, 8, 6 。
 * <p>
 * 2, 3, 4, 5, 7 旋转 180° 后，得到的不是数字。
 * <p>
 * 易混淆数 (confusing number) 在旋转180°以后，可以得到和原来不同的数，且新数字的每一位都是有效的。
 *
 * <p>
 * 提示
 * 0 <= N <= 10^9
 * 可以忽略掉旋转后得到的前导零，例如，如果我们旋转后得到 0008 那么该数字就是 8 。
 */
public class ConfusingNumber {

  //  如 0, 1, 6, 8, 9 旋转 180° 以后，得到了新的数字 0, 1, 9, 8, 6 。
//   2, 3, 4, 5, 7 旋转 180° 后，得到的不是数字。
  private static final int[] map = new int[]{0, 1, -1, -1, -1, -1, 9, -1, 8, 6};

  /**
   * 暴力解法，直接把数字转为字符串然后反转，之后遍历字符串做映射检查
   */
  public static boolean confusingNumberX(int n) {
    String nStr = String.valueOf(n);
    int newValue = 0;
    for (int i = 0; i < nStr.length(); i++) {
      int v = map[nStr.charAt(nStr.length() - 1 - i) - '0'];
      if (v == -1) {
        return false;
      }
      newValue = (newValue * 10) + v;
    }
    System.out.format("\n n %s, confusingNum %s", n, newValue);
    return newValue != n;
  }

  /**
   * 优化，自己计算出每个数字，，先创建一个0-9数字，180度之后的字典映射关系
   * 遍历整数的每一位，逆序，然后组成数字
   * 时间复杂度 O(n)  , n 位数字
   * 空间复杂度 0(1), 使用了映射表, 但是常量表长度固定是10
   *
   * @param n
   * @return
   */
  public static boolean confusingNumber(int n) {
    int div = n;
    int ys;
    int newValue = 0;
    while (div != 0) {
      ys = div % 10;
      div = div / 10;
      if (map[ys] == -1) {
        return false;
      }
      newValue = (newValue * 10) + map[ys];
    }
    System.out.format("\n n %s, confusingNum %s", n, newValue);
    return newValue != n;
  }
}
