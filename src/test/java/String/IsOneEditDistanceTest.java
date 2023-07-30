package String;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IsOneEditDistanceTest {

  /**
   * 示例 1：
   *
   * 输入: s = "ab", t = "acb"
   * 输出: true
   * 解释: 可以将 'c' 插入字符串 s 来得到 t。
   * 示例 2:
   *
   * 输入: s = "cab", t = "ad"
   * 输出: false
   * 解释: 无法通过 1 步操作使 s 变为 t。
   */
  @Test
  public void isOneEditDistance() {
    Assertions.assertTrue(IsOneEditDistance.isOneEditDistance("ab", "acb"));
    Assertions.assertFalse(IsOneEditDistance.isOneEditDistance("cab", "ad"));
    Assertions.assertTrue(IsOneEditDistance.isOneEditDistance("", "a"));
    Assertions.assertTrue(IsOneEditDistance.isOneEditDistance("b", ""));
    Assertions.assertFalse(IsOneEditDistance.isOneEditDistance("b", "b"));
    Assertions.assertTrue(IsOneEditDistance.isOneEditDistance("cb", "ab"));
  }

  @Test
  public void isOneEditDistanceOpt() {
    Assertions.assertTrue(IsOneEditDistance.isOneEditDistanceOpt("ab", "acb"));
    Assertions.assertFalse(IsOneEditDistance.isOneEditDistanceOpt("cab", "ad"));
    Assertions.assertTrue(IsOneEditDistance.isOneEditDistanceOpt("", "a"));
    Assertions.assertTrue(IsOneEditDistance.isOneEditDistanceOpt("b", ""));
    Assertions.assertFalse(IsOneEditDistance.isOneEditDistanceOpt("b", "b"));
    Assertions.assertTrue(IsOneEditDistance.isOneEditDistanceOpt("cb", "ab"));
  }
}