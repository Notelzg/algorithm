package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConfusingNumberTest {

  /**
   *  输入：6
   *  * 输出：true
   *  * 解释：
   *  * 把 6 旋转 180° 以后得到 9，9 是有效数字且 9!=6 。
   *  * <p>
   *  * 输入：89
   *  * 输出：true
   *  * 解释:
   *  * 把 89 旋转 180° 以后得到 68，86 是有效数字且 86!=89 。
   *  * <p>
   *  * 输入：11
   *  * 输出：false
   *  * 解释：
   *  * 把 11 旋转 180° 以后得到 11，11 是有效数字但是值保持不变，所以 11 不是易混淆数字。
   */
  @Test
  public void confusingNumber() {
    assertTrue(ConfusingNumber.confusingNumber(6));
    assertTrue(ConfusingNumber.confusingNumber(89));
    assertFalse(ConfusingNumber.confusingNumber(11));
    assertFalse(ConfusingNumber.confusingNumber(916));
  }

  @Test
  public void confusingNumberX() {
    assertFalse(ConfusingNumber.confusingNumberX(916));
    assertTrue(ConfusingNumber.confusingNumberX(6));
    assertTrue(ConfusingNumber.confusingNumberX(89));
    assertFalse(ConfusingNumber.confusingNumberX(11));
  }
}