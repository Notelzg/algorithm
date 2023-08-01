package String;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShortestWayTest {
  ShortestWay service = new ShortestWay();

  /**
   * 例 1：
   * <p>
   * 输入：source = "abc", target = "abcbc"
   * 输出：2
   * 解释：目标字符串 "abcbc" 可以由 "abc" 和 "bc" 形成，它们都是源字符串 "abc" 的子序列。
   * 示例 2：
   * <p>
   * 输入：source = "abc", target = "acdbc"
   * 输出：-1
   * 解释：由于目标字符串中包含字符 "d"，所以无法由源字符串的子序列构建目标字符串。
   * 示例 3：
   * <p>
   * 输入：source = "xyz", target = "xzyxz"
   * 输出：3
   * 解释：目标字符串可以按如下方式构建： "xz" + "y" + "xz"。
   */
  @Test
  public void shortestWay() {
    Assertions.assertEquals(2, service.shortestWay("abc", "abcbc"));
    Assertions.assertEquals(-1, service.shortestWay("abc", "acdbc"));
    Assertions.assertEquals(3, service.shortestWay("xyz", "xzyxz"));
  }
}