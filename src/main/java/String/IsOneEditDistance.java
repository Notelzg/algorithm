package String;

/**
 * 给定两个字符串 s 和 t ，如果它们的编辑距离为 1 ，则返回 true ，否则返回 false 。
 * <p>
 * 字符串 s 和字符串 t 之间满足编辑距离等于 1 有三种可能的情形：
 * <p>
 * 往 s 中插入 恰好一个 字符得到 t
 * 从 s 中删除 恰好一个 字符得到 t
 * 在 s 中用 一个不同的字符 替换 恰好一个 字符得到 t
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "ab", t = "acb"
 * 输出: true
 * 解释: 可以将 'c' 插入字符串 s 来得到 t。
 * 示例 2:
 * <p>
 * 输入: s = "cab", t = "ad"
 * 输出: false
 * 解释: 无法通过 1 步操作使 s 变为 t。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 0 <= s.length, t.length <= 104
 * s 和 t 由小写字母，大写字母和数字组成
 */
public class IsOneEditDistance {
  /**
   * 暴力解法
   * * 往 s 中插入 恰好一个 字符得到 t
   * * 从 s 中删除 恰好一个 字符得到 t
   * * 在 s 中用 一个不同的字符 替换 恰好一个 字符得到 t
   * 从题目中，可以看到只有3种情况，才能返回true
   * 而三种情况分布是，
   * 插入, s.length + 1 == t.length, 双指针，从前向后，找到相同的则加+1，不同的 t 跳过一次，继续走，如果后面都一样，只有一个不同则，则返回true
   * 删除, s.length -1 == t.length,双指针，从前向后，找到相同的则加+1，不同的 s 跳过一次，继续走，如果后面都一样，只有一个不同则，则返回true
   * 替换, s.length ==  t.length, 双指针，从前向后，找到相同的则加+1，不同的 t,s 跳过一次，继续走，如果后面都一样，只有一个不同则，则返回true
   * 所以可以根据长度，进行不同的策略的对比
   * 注意，如果
   */
  public static boolean isOneEditDistance(String s, String t) {
    if (s.isEmpty() && t.isEmpty()) {
      return false;
    }
    int sIndex = 0;
    int tIndex = 0;
    if (s.length() + 1 == t.length()) {
      while (sIndex < s.length() && tIndex < t.length()) {
        if (s.charAt(sIndex) == t.charAt(tIndex)) {
          sIndex++;
          tIndex++;
        } else {
          tIndex++;
        }
      }
      // 只要s遍历完成，就是符合预期
      return sIndex == s.length();
    } else if (s.length() - 1 == t.length()) {
      while (sIndex < s.length() && tIndex < t.length()) {
        if (s.charAt(sIndex) == t.charAt(tIndex)) {
          sIndex++;
          tIndex++;
        } else {
          sIndex++;
        }
      }
      // 只要t遍历完成，就是符合预期
      return tIndex == t.length();
    } else if (s.length() == t.length()) {
      int firstEqualsCount = 0;
      while (sIndex < s.length() && tIndex < t.length() && firstEqualsCount < 2) {
        if (s.charAt(sIndex) == t.charAt(tIndex)) {
          sIndex++;
          tIndex++;
        } else {
          sIndex++;
          tIndex++;
          firstEqualsCount++;
        }
      }
      // 只要t遍历完成，就是符合预期
      return tIndex == t.length() && firstEqualsCount == 1;
    }
    return false;
  }

  public static boolean isOneEditDistanceOpt(String s, String t) {
    if (Math.abs(s.length() - t.length()) > 1 || (s.isEmpty() && t.isEmpty())) {
      return false;
    }
    if (s.length() > t.length()) {
      return isOneInsert(t, s);
    } else if (s.length() < t.length()) {
      return isOneInsert(s, t);
    } else {
      int notEqualCount = 0;
      int i;
      for (i = 0; i < s.length() && notEqualCount < 2; i++) {
        if (s.charAt(i) != t.charAt(i)) {
          notEqualCount++;
        }
      }
      return notEqualCount == 1 && i == s.length();
    }

  }

  public static boolean isOneInsert(String s, String t) {
    int sIndex = 0;
    int tIndex = 0;
    while (sIndex < s.length() && tIndex < t.length()) {
      if (s.charAt(sIndex) == t.charAt(tIndex)) {
        sIndex++;
        tIndex++;
      } else {
        tIndex++;
      }
      if (tIndex - sIndex > 1) {
        return false;
      }
    }
    // 只要s遍历完成，就是符合预期
    return sIndex == s.length();
  }
}
