package window;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LengthOfLongestSubstringKDistinctTest {

  /**
   * 示例 1：
   *
   * 输入：s = "eceba", k = 2
   * 输出：3
   * 解释：满足题目要求的子串是 "ece" ，长度为 3 。
   * 示例 2：
   *
   * 输入：s = "aa", k = 1
   * 输出：2
   * 解释：满足题目要求的子串是 "aa" ，长度为 2 。
   */
  @Test
  public void solution() {
    LengthOfLongestSubstringKDistinct service = new LengthOfLongestSubstringKDistinct();
    Assertions.assertEquals(5, service.solution("eceba", 4));
    Assertions.assertEquals(4, service.solution("eceba", 3));
    Assertions.assertEquals(3, service.solution("eceba", 2));
    Assertions.assertEquals(2, service.solution("aa", 1));
    Assertions.assertEquals(2, service.solution("abcabcabc", 2));
    Assertions.assertEquals(6, service.solution("ababcbcbaaabbdef", 2));
    Assertions.assertEquals(7, service.solution("ababacccccc", 2));
    Assertions.assertEquals(3, service.solution("eceba", 2));
    Assertions.assertEquals(5, service.solution("ccaabbb", 2));
    Assertions.assertEquals(1, service.solution("a", 2));
    Assertions.assertEquals(11, service.solution("aaaabbbbbbb", 2));
  }

  @Test
  public void solutionCount() {
    LengthOfLongestSubstringKDistinct service = new LengthOfLongestSubstringKDistinct();
    Assertions.assertEquals(5, service.solutionCount("eceba", 4));
    Assertions.assertEquals(4, service.solutionCount("eceba", 3));
    Assertions.assertEquals(3, service.solutionCount("eceba", 2));
    Assertions.assertEquals(2, service.solutionCount("aa", 1));
    Assertions.assertEquals(2, service.solutionCount("abcabcabc", 2));
    Assertions.assertEquals(6, service.solutionCount("ababcbcbaaabbdef", 2));
    Assertions.assertEquals(7, service.solutionCount("ababacccccc", 2));
    Assertions.assertEquals(3, service.solutionCount("eceba", 2));
    Assertions.assertEquals(5, service.solutionCount("ccaabbb", 2));
    Assertions.assertEquals(1, service.solutionCount("a", 2));
    Assertions.assertEquals(11, service.solutionCount("aaaabbbbbbb", 2));
  }
}