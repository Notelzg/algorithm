package String;

import java.util.Arrays;

/**
 * 反转字符串中的单词 II
 * 给你一个字符数组 s ，反转其中 单词 的顺序。
 * 单词 的定义为：单词是一个由非空格字符组成的序列。s 中的单词将会由单个空格分隔。
 * 必须设计并实现 原地 解法来解决此问题，即不分配额外的空间。
 * 示例 1：
 * <p>
 * 输入：s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * 输出：["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * 示例 2：
 * <p>
 * 输入：s = ["a"]
 * 输出：["a"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i] 可以是一个英文字母（大写或小写）、数字、或是空格 ' ' 。
 * s 中至少存在一个单词
 * s 不含前导或尾随空格
 * 题目数据保证：s 中的每个单词都由单个空格分隔
 */
public class ReverseWords {
  /**
   * 暴力解法，就是重新申请一个新的数组，从前到后进行遍历数组，遇到空格，则是一个单词
   * 需要把单词放到后面去, 把前面的单词放到后面去，进行一个交换
   * 过程比较复杂，时间复杂度 ， 循环最大次数是 n，每次遇到一个空格，会进行复制
   * 假设有i个单词，2n次，但是过程比较复杂
   * 复制的第一次是 n
   * 第2次是  n - w1
   * 第3次是  n - w2 - v1
   * 第i次是  n - ... wi - w2 - v1
   * 空间复杂度比较高 是 O(N)
   *
   * @param s
   */
  public void reverseWords(char[] s) {
    int count = 0;
    while (count < s.length) {
      int preIndex = 0;
      for (int i = 0; i < s.length; i++) {
        if (s[i] == ' ') {
          char[] temp = new char[i - preIndex + 1];
          if (count + temp.length >= s.length) {
            return;
          }
          temp[0] = ' ';
          System.out.printf("\npreIndex %s, i %s, source %s, ", preIndex, i, Arrays.toString(s));
          System.arraycopy(s, preIndex, temp, 1, temp.length - 1);
          // 数组向左移动一个单词
          System.arraycopy(s, i + 1, s, 0, s.length - i - 1 - count);
          // 把单词放到最后面
          System.arraycopy(temp, 0, s, s.length - i - 1 - count, temp.length);
          System.out.printf("result %s", Arrays.toString(s));
          count += temp.length;
          break;
        }
      }
      if (count == 0) {
        return;
      }
    }
  }

  /**
   * 优化算法, 空间复杂度 O(n), 搞成 O(1)
   * 使用空间的原因是每次需要把交换的单词复制出来，进行移动
   * 原因是不能提前之前单词的长度，因为每个单词本身要是正常顺序，不能是逆序
   * 所以其实可以先放单词的逆序，然后反转逆序的单词，这样就可以一次逆转一个字符
   * 而不是整个单词。
   * 所以思路可以是每次移动一个字符，把第一个和最后一个交换，一直交换，最后对逆序的单词
   * 再逆序，得到正常的单词
   * 时间复杂度O(n), 两次遍历数组 2n
   * 空间复杂度 O(1), pre + temp , 2 个
   * @param s
   */
  public void reverseWordsOpt(char[] s) {
    // 1. 整个逆序
    reverse(s, 0, s.length - 1);
    //2 单词逆序
    int pre = 0;
    for (int i = 0; i < s.length; i++) {
      if (s[i] == ' ') {
        reverse(s, pre, i - 1);
        pre = i + 1;
      }
    }
    // 3. 最后一个单词
    reverse(s, pre, s.length - 1);
  }

  public void reverse(char[] s, int left, int right) {
    while (left < right) {
      char temp = s[left];
      s[left++] = s[right];
      s[right--] = temp;
    }
  }

}
