package String;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StringShiftTest {
  /**
   * 示例 1：
   * * <p>
   * * 输入：s = "abc", shift = [[0,1],[1,2]]
   * * 输出："cab"
   * * 解释：
   * * [0,1] 表示左移 1 位。 "abc" -> "bca"
   * * [1,2] 表示右移 2 位。 "bca" -> "cab"
   * * 示例 2：
   * * <p>
   * * 输入：s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
   * * 输出："efgabcd"
   */
  @Test
  public void stringShift() {
    Assertions.assertEquals("cab", StringShift.stringShift("abc", string2ArrayArray("[[0,1],[1,2]]")));
    Assertions.assertEquals("efgabcd", StringShift.stringShift("abcdefg", string2ArrayArray("[[1,1],[1,1],[0,2],[1,3]]")));
    Assertions.assertEquals("a", StringShift.stringShift("a", string2ArrayArray("[[1,1],[1,1],[0,2],[1,3],[0,0]]")));
    Assertions.assertEquals("bca", StringShift.stringShift("abc", string2ArrayArray("[[0,4]]")));
  }

  static int[][] string2ArrayArray(String s) {
    if (s.startsWith("[[")) {
      s = s.substring(2);
    }
    if (s.endsWith("]]")) {
      s = s.substring(0, s.length() - 2);
    }
    String[] sArr = s.split("],");
    int[][] arr = new int[sArr.length][];
    for (int i = 0; i < sArr.length; i++) {
        arr[i] = string2array(sArr[i]);
    }
    System.out.printf("\n string2ArrayArray string %s, array %s", s, Arrays.toString(arr));
    return arr;
  }

  public static int[] string2array(String s) {
    if (s.startsWith("[")) {
      s = s.substring(1);
    }
    if (s.endsWith("]")) {
      s = s.substring(0, s.length() - 1);
    }
    String[] sArr = s.split(",");
    int[] arr = new int[sArr.length];
    for (int i = 0; i < sArr.length; i++) {
      arr[i] = Integer.parseInt(sArr[i]);
    }
    return arr;
  }
}