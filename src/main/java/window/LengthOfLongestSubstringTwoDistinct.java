package window;

import java.util.*;

/**
 * 159. 至多包含两个不同字符的最长子串
 * 你一个字符串 s ，请你找出 至多 包含 两个不同字符 的最长子串，并返回该子串的长度。
 * 示例 1：
 * 输入：s = "eceba"
 * 输出：3
 * 解释：满足题目要求的子串是 "ece" ，长度为 3 。
 * 示例 2：
 * 输入：s = "ccaabbb"
 * 输出：5
 * 解释：满足题目要求的子串是 "aabbb" ，长度为 5 。
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 由英文字母组成
 */
public class LengthOfLongestSubstringTwoDistinct {
  /**
   * 思路，最长子串，就要求一定是连续的，就是滑动窗口的问题
   * 双指针，一个指向当前，一个指向子串开始的位置
   * 一个计数器，记录当前不同字符的个数
   * 最多2个不同的字符串，属于限制条件，也就是截止条件，判断条件
   * 当然也存在都是同一个字符串的情况
   * 暴力解法，
   * 就是遍历字符串，如果子串为空，则添加，不为空如果包含也添加
   * 否则，就看当前子串中不同字符的个数，如果为2则，当前的子串已经
   * 是当前窗口的最大子串了。这个时候需要从该字符串出发寻找，向前寻找
   * 一个包含该字符的最大子串，进行对比，哪个大则当前最大子串就是谁
   * 直到数组为空未知。
   *
   * @param s
   * @return
   */
  public int lengthOfLongestSubstringTwoDistinct(String s) {
    int dc = 1;
    int left = 0;
    int right = 0;
    for (int i = 1; i < s.length(); i++) {
      if (!containsChar(s, left, right, s.charAt(i))) {
        dc++;
      }
      if (dc <= 2) {
        right = i;
      } else {
        System.out.printf("\n left %s, right %s, dc %s, subString %s", left, right, dc, s.substring(left, right + 1));
        int jDc = 1;
        int j;
        for (j = i - 1; j >= left; j--) {
          if (!containsChar(s, j + 1, i, s.charAt(j))) {
            jDc++;
          }
          if (jDc > 2) {
            break;
          }
        }
        System.out.printf("\n i %s, jPre %s, jdc %s, subString %s", i, j + 1, jDc, s.substring(j + 1, i + 1));
        if ((right - left) < (i - j - 1)) {
          left = j + 1;
          right = i;
          dc = jDc;
        }
      }
    }
    return right - left + 1;
  }

  /**
   * @param s
   * @param start include
   * @param end   include
   * @param c
   * @return
   */
  private boolean containsChar(String s, int start, int end, char c) {
    for (int i = end; i >= start; i--) {
      if (s.charAt(i) == c) {
        return true;
      }
    }
    return false;
  }

  private int find(String s, int start, int end, char c) {
    int i;
    for (i = end; i > start; i--) {
      if (s.charAt(i) != c && s.charAt(i) != s.charAt(i - 1)) {
        return i;
      }
    }
    return start;
  }

  public int lengthOfLongestSubstringTwoDistinctOpt(String s) {
    char[] window = new char[2];
    int left = 0;
    int right = 0;
    for (int i = 1; i < s.length(); i++) {
      if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
        continue;
      }
      window[0] = s.charAt(i);
      window[1] = '=';
      int j;
      for (j = i - 1; j >= 0; j--) {
        char tj = s.charAt(j);
        if (tj == window[0] || window[1] == tj) {
          continue;
        }
        if (window[1] == '=') {
          window[1] = tj;
          continue;
        }
        break;
      }
      System.out.printf("\n j %s, i %s, dc %s, subString %s", j, i, Arrays.toString(window), s.substring(j + 1, i + 1));
      if (i - j > (right - left)) {
        left = j + 1;
        right = i;
      }
    }
    return right - left + 1;
  }

  /**
   * 用滑动窗口的该概念来处理
   * 维持窗口的大小，如果包含的不同的子串个数大于2，则窗口需要调额
   * 把最左边的移动一位（但是因为存在重复的情况，所以记录重复字符最后一次的位置）
   *
   * @param
   * @return
   */
  static class Node {
    char item;
    int index;

    public Node(char item, int index) {
      this.item = item;
      this.index = index;
    }

    @Override
    public String toString() {
      return "Node{" +
              "item=" + item +
              ", index=" + index +
              '}';
    }
  }

  public int lengthOfLongestSubstringTwoDistinctWindow(String s) {
    System.out.println("\nstring " + s);
    int left = 0;
    int maxLen = 1;
    int right;
    Node[] windowNode = new Node[2];
    windowNode[0] = new Node(s.charAt(0), 0);
    windowNode[1] = new Node('=', -1);
    for (right = 1; right < s.length(); right++) {
      if (windowNode[0].item == s.charAt(right)) {
        windowNode[0].index = right;
        continue;
      }
      if (windowNode[1].item == s.charAt(right)) {
        windowNode[1].index = right;
        continue;
      }
      if (windowNode[0].item == '=') {
        windowNode[0].item = s.charAt(right);
        windowNode[0].index = right;
        continue;
      }
      if (windowNode[1].item == '=') {
        windowNode[1].item = s.charAt(right);
        windowNode[1].index = right;
        continue;
      }
      // 窗口调整
      System.out.printf("\n left %s, i %s, dc %s, subString %s", left, right, Arrays.toString(windowNode), s.substring(left, right));
      // + 1是因为需要去下一个不同的字符，不能是自己，相当于是右移一位
      maxLen = Math.max(maxLen, right - left);
      int index = windowNode[1].index < windowNode[0].index ? 1 : 0;
      left = windowNode[index].index + 1;
      windowNode[index].item = s.charAt(right);
      windowNode[index].index = right;
    }
    return Math.max(maxLen, right - left);
  }

  /**
   * 不自己维护，而是使用hashmap维护，数组的下标
   * 如果hashMap中的元素个数大于2则，标识窗口超过限制了，需要进行右移动一位
   * 从hashMap中选择出最小的然后删除掉，就能保证窗口的有效性
   *
   * @param s
   * @return
   */
  public int lengthOfLongestSubstringTwoDistinctWindowHashMap(String s) {
    System.out.println("\nstring " + s);
    int maxLen = 1;
    int left = 0;
    int right = 0;
    HashMap<Character, Integer> map = new HashMap<>();
    for (right = 0; right < s.length(); right++) {
      map.put(s.charAt(right), right);
      if (map.size() > 2) {
        maxLen = Math.max(maxLen, right - left);
        System.out.printf("\n left %s, i %s, map %s, subString %s", left, right, map.toString(), s.substring(left, right));
        left = Collections.min(map.values());
        left = map.remove(s.charAt(left)) + 1;
      }
    }
    return Math.max(maxLen, right - left);
  }

  /**
   * hashMap 每次都需要遍历所有的，取出最小的，其实可以用linkedHashMap
   * 来获取最近没有访问的，这样就是最小的，
   */
  public int lengthOfLongestSubstringTwoDistinctWindowLinked(String s) {
    final int[] left = {0};
    int right = 0;
    int maxLen = 0;
    LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<Character, Integer>(3, 0.75f, true) {
      @Override
      protected boolean removeEldestEntry(Map.Entry<Character, Integer> eldest) {
        if (this.size() > 2) {
          left[0] = eldest.getValue() + 1;
          return true;
        }
        return false;
      }
    };
    for (right = 0; right < s.length(); right++) {
      linkedHashMap.put(s.charAt(right), right);
      maxLen = Math.max(maxLen, right - left[0] + 1);
    }
    return maxLen;

  }

}
