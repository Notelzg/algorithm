package window;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 给你一个字符串 s 和一个整数 k ，请你找出 至多 包含 k 个 不同 字符的最长子串，并返回该子串的长度。
 * 示例 1：
 * <p>
 * 输入：s = "eceba", k = 2
 * 输出：3
 * 解释：满足题目要求的子串是 "ece" ，长度为 3 。
 * 示例 2：
 * <p>
 * 输入：s = "aa", k = 1
 * 输出：2
 * 解释：满足题目要求的子串是 "aa" ，长度为 2 。
 * 提示：
 * <p>
 * 1 <= s.length <= 5 * 104
 * 0 <= k <= 50
 */
public class LengthOfLongestSubstringKDistinct {
  public int solution(String s, int k) {
    if (k == 0) {
      return 0;
    }
    final int[] left = {0};
    int right = 0;
    int maxLen = 1;
    LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>(k, 0.75f, true) {
      @Override
      protected boolean removeEldestEntry(Map.Entry<Character, Integer> eldest) {
        if (this.size() > k) {
          left[0] = eldest.getValue() + 1;
          return true;
        }
        return false;
      }
    };
    for (right = 0; right < s.length(); right++) {
      map.put(s.charAt(right), right);
      maxLen = Math.max(maxLen, right - left[0] + 1);
    }
    return maxLen;
  }

  /**
   * 两种解法，一种是使用hash字典，记录字符的下标的位置，每次重复出现的时候进行更新
   * 保证每个字符都是是其最后一个遍历的地方，这样下标+1，就可以移动到下一个元素
   * 使用字典的原因就是字符是可以重复出现的。
   * 另外一种思路就是记录元素出现的次数，这里由于字符串正常是ascii码值
   * 只有128个字母，所以使用128长度的数组，就可以获取所有的字符
   * 然后统计其出现的次数。
   * 同时记录不同字符的个数，如果大于条件，则进行调整，
   * 这个时候需要获取最左边的字符，这个时候从s.chart(0)开始访问在count中
   * 出现的次数，然后次数减去1，如果等于0，证明这个就是最左边的字符，然后+1
   * 就是left
   *
   * @param s
   * @param k
   * @return
   */
  public int solutionCount(String s, int k) {
    if (k == 0) {
      return 0;
    }
    int left = 0;
    int right = 0;
    int maxLen = 1;
    int diffCount = 0;
    int[] count = new int[128];
    for (right = 0; right < s.length(); right++) {
      if (count[s.charAt(right)]++ == 0) {
        diffCount++;
      }
      // 非重复的字符大于k个了，需要调整left
      if (diffCount > k) {
        // 也可以每次都计算，在每次循环的时候
        while (diffCount > k) {
          if (--count[s.charAt(left++)] == 0) {
            diffCount--;
          }
        }
      }
      maxLen = Math.max(maxLen, right - left + 1);
    }
    // 这里计算一下是因为, 存在
    return maxLen;
  }


}
