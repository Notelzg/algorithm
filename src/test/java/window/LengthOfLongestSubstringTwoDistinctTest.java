package window;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LengthOfLongestSubstringTwoDistinctTest {
  /**
   *  示例 1：
   *  * 输入：s = "eceba"
   *  * 输出：3
   *  * 解释：满足题目要求的子串是 "ece" ，长度为 3 。
   *  * 示例 2：
   *  * 输入：s = "ccaabbb"
   *  * 输出：5
   *  * 解释：满足题目要求的子串是 "aabbb" ，长度为 5 。
   */

  @Test
  public void lengthOfLongestSubstringTwoDistinct() {
    LengthOfLongestSubstringTwoDistinct service = new LengthOfLongestSubstringTwoDistinct();
    Assertions.assertEquals(6, service.lengthOfLongestSubstringTwoDistinct("ababcbcbaaabbdef"));
    Assertions.assertEquals(7, service.lengthOfLongestSubstringTwoDistinct("ababacccccc"));
    Assertions.assertEquals(3, service.lengthOfLongestSubstringTwoDistinct("eceba"));
    Assertions.assertEquals(5, service.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    Assertions.assertEquals(1, service.lengthOfLongestSubstringTwoDistinct("a"));
    Assertions.assertEquals(11, service.lengthOfLongestSubstringTwoDistinct("aaaabbbbbbb"));
  }

  @Test
  public void lengthOfLongestSubstringTwoDistinctOpt() {
    LengthOfLongestSubstringTwoDistinct service = new LengthOfLongestSubstringTwoDistinct();
    Assertions.assertEquals(6, service.lengthOfLongestSubstringTwoDistinctOpt("ababcbcbaaabbdef"));
    Assertions.assertEquals(7, service.lengthOfLongestSubstringTwoDistinctOpt("ababacccccc"));
    Assertions.assertEquals(3, service.lengthOfLongestSubstringTwoDistinctOpt("eceba"));
    Assertions.assertEquals(5, service.lengthOfLongestSubstringTwoDistinctOpt("ccaabbb"));
    Assertions.assertEquals(1, service.lengthOfLongestSubstringTwoDistinctOpt("a"));
    Assertions.assertEquals(11, service.lengthOfLongestSubstringTwoDistinctOpt("aaaabbbbbbb"));
  }

  @Test
  public void lengthOfLongestSubstringTwoDistinctWindow() {
    LengthOfLongestSubstringTwoDistinct service = new LengthOfLongestSubstringTwoDistinct();
    Assertions.assertEquals(2, service.lengthOfLongestSubstringTwoDistinctWindow("abcabcabc"));
    Assertions.assertEquals(6, service.lengthOfLongestSubstringTwoDistinctWindow("ababcbcbaaabbdef"));
    Assertions.assertEquals(7, service.lengthOfLongestSubstringTwoDistinctWindow("ababacccccc"));
    Assertions.assertEquals(3, service.lengthOfLongestSubstringTwoDistinctWindow("eceba"));
    Assertions.assertEquals(5, service.lengthOfLongestSubstringTwoDistinctWindow("ccaabbb"));
    Assertions.assertEquals(1, service.lengthOfLongestSubstringTwoDistinctWindow("a"));
    Assertions.assertEquals(11, service.lengthOfLongestSubstringTwoDistinctWindow("aaaabbbbbbb"));
  }

  @Test
  public void lengthOfLongestSubstringTwoDistinctHashMap() {
    LengthOfLongestSubstringTwoDistinct service = new LengthOfLongestSubstringTwoDistinct();
    Assertions.assertEquals(2, service.lengthOfLongestSubstringTwoDistinctWindowHashMap("abcabcabc"));
    Assertions.assertEquals(6, service.lengthOfLongestSubstringTwoDistinctWindowHashMap("ababcbcbaaabbdef"));
    Assertions.assertEquals(7, service.lengthOfLongestSubstringTwoDistinctWindowHashMap("ababacccccc"));
    Assertions.assertEquals(3, service.lengthOfLongestSubstringTwoDistinctWindowHashMap("eceba"));
    Assertions.assertEquals(5, service.lengthOfLongestSubstringTwoDistinctWindowHashMap("ccaabbb"));
    Assertions.assertEquals(1, service.lengthOfLongestSubstringTwoDistinctWindowHashMap("a"));
    Assertions.assertEquals(11, service.lengthOfLongestSubstringTwoDistinctWindowHashMap("aaaabbbbbbb"));
  }

  @Test
  public void lengthOfLongestSubstringTwoDistinctWindowLinked() {
    LengthOfLongestSubstringTwoDistinct service = new LengthOfLongestSubstringTwoDistinct();
    Assertions.assertEquals(2, service.lengthOfLongestSubstringTwoDistinctWindowLinked("abcabcabc"));
    Assertions.assertEquals(6, service.lengthOfLongestSubstringTwoDistinctWindowLinked("ababcbcbaaabbdef"));
    Assertions.assertEquals(7, service.lengthOfLongestSubstringTwoDistinctWindowLinked("ababacccccc"));
    Assertions.assertEquals(3, service.lengthOfLongestSubstringTwoDistinctWindowLinked("eceba"));
    Assertions.assertEquals(5, service.lengthOfLongestSubstringTwoDistinctWindowLinked("ccaabbb"));
    Assertions.assertEquals(1, service.lengthOfLongestSubstringTwoDistinctWindowLinked("a"));
    Assertions.assertEquals(11, service.lengthOfLongestSubstringTwoDistinctWindowLinked("aaaabbbbbbb"));
  }
}