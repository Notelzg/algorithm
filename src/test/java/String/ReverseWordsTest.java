package String;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ReverseWordsTest {

  /**
   * 示例 1：
   *
   * 输入：s = ['t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e']
   * 输出：['b','l','u','e',' ','i','s',' ','s','k','y',' ','t','h','e']
   * 示例 2：
   *
   * 输入：s = ['a']
   * 输出：['a']
   */
  @Test
  public void reverseWords() {
    ReverseWords reverseWords = new ReverseWords();
    char[] s = new char[]{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
    char[] e = new char[]{'b','l','u','e',' ','i','s',' ','s','k','y',' ','t','h','e'};
    reverseWords.reverseWords(s);
    assertArrayEquals(e, s);
    s = new char[]{'a'};
    e = new char[]{'a'};
    reverseWords.reverseWords(s);
    assertArrayEquals(e, s);
  }

  @Test
  public void reverseWordsOpt() {
    ReverseWords reverseWords = new ReverseWords();
    char[] s = new char[]{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
    char[] e = new char[]{'b','l','u','e',' ','i','s',' ','s','k','y',' ','t','h','e'};
    reverseWords.reverseWordsOpt(s);
    assertArrayEquals(e, s);
    s = new char[]{'a'};
    e = new char[]{'a'};
    reverseWords.reverseWordsOpt(s);
    assertArrayEquals(e, s);
  }
}