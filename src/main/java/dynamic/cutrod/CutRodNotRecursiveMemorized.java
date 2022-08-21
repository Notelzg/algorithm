package dynamic.cutrod;

/**
 * 钢条切割问题
 * 非递归解,自底向上求解
 * 时间复杂度 O(n^2)
 * 空间复杂度 O(n)
 */
public class CutRodNotRecursiveMemorized {
  public static int solution(int n, int[] prices) {
    // 其实可以是n,但是为了方便阅读，这里长度设置为n+1, 下标，0其实没有用
    int[] expects = new int[n + 1];
    int[] cuts = new int[n + 1];

    // 标识，钢条的长度，从1开始，慢慢增加到n，为了高长度的利用低长度的最优解
    // 因为钢条长度为n, 所以要等于n
    for (int i = 1; i <= n; i++) {
      int priceMax = 0;
      // 遍历所有的切割情况
      for (int j = 1; j <= i; j++) {
        int price = prices[j] + expects[i - j];
        if (priceMax < price) {
          priceMax = price;
          cuts[i] = j;
        }
      }
      expects[i] = priceMax;
    }
    printCut(n, cuts);
    return expects[n];
  }

  public static void printCut(int n, int[] cuts) {
    System.out.printf("\nn = %s: ", n);
    while (n > 0) {
      System.out.printf(", %s", cuts[n]);
      n -= cuts[n];
    }
  }
}
