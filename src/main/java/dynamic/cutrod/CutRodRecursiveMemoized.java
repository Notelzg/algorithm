package dynamic.cutrod;

/**
 * 带备忘录的递归切割
 * 时间复杂度 O(n^2)
 * 空间复杂度 O(n)
 * 为何时间复杂度从指数级别，降低到了n^2呢？
 * 递归调用的计算起来比较复杂
 * solutionAux 这个方法的调用次数，
 * 当 n = n 时，调用了 n次
 *   n-1时，调用了n-1次
 *   1， 调用了1次
 *   递归调用从1，开始向上浮动，由于有辅助数组记录
 *   最优解，所以向上浮动的过程中，不会重复计算子问题，所以
 *   每层调用的次数加起来，就是总的调用次数
 *   n+n-1+...1
 *   n*(n+1)/2  ，， 所以时间复杂度是 O(n^2)
 *
 *
 */
public class CutRodRecursiveMemoized {

  public static int solution(int n, int[] prices) {
    int[] expects = new int[n + 1];
    int[] cuts = new int[n + 1];
    return solutionAux(n, prices, expects, cuts);
  }

  private static int solutionAux(int n, int[] prices, int[] expects, int[] cuts) {
    if (n == 0) {
      return 0;
    }
    if (expects[n] > 0) {
      return expects[n];
    }
    int pricesMax = 0;
    for (int i = 1; i <= n; i++) {
      int price = prices[i] + solutionAux(n - i, prices, expects, cuts);
      if (pricesMax < price) {
        pricesMax = price;
        cuts[n] = i;
      }
    }
    expects[n] = pricesMax;
    return pricesMax;
  }
}
