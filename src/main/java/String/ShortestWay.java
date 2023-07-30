package String;

/**
 * 对于任何字符串，我们可以通过删除其中一些字符（也可能不删除）来构造该字符串的 子序列 。(例如，“ace” 是 “abcde” 的子序列，而 “aec” 不是)。
 * <p>
 * 给定源字符串 source 和目标字符串 target，返回 源字符串 source 中能通过串联形成目标字符串 target 的 子序列 的最小数量 。如果无法通过串联源字符串中的子序列来构造目标字符串，则返回 -1。
 * 示例 1：
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
public class ShortestWay {
  /**
   * 双指针遍历
   * 遍历 target 字符串，
   * 使用 target[i] 遍历 source，相等则，都加1，否则 target 跳过一个元素
   * 如果遍历一遍 target一个都没有匹配，则返回false
   *
   * @param source
   * @param target
   * @return
   */
  public int shortestWay(String source, String target) {
    int tIndex = 0;
    int sIndex = 0;
    int preIndex = 0;
    int count = 0;
    while (tIndex < target.length()) {
      sIndex = 0;
      preIndex = tIndex;
      while (sIndex < source.length() && tIndex < target.length()) {
        if (source.charAt(sIndex) == target.charAt(tIndex)) {
          tIndex++;
        }
        sIndex++;
      }
      if (tIndex == preIndex) {
        return -1;
      } else {
        count++;
        System.out.println(target.substring(preIndex, tIndex));
      }
    }
    return tIndex == target.length() ? count : -1;
  }
}
