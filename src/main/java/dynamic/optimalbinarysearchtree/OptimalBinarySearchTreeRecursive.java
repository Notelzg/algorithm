package dynamic.optimalbinarysearchtree;

/**
 * 最优二叉搜索树
 * 我们知道有平衡二叉树、红黑树等平衡树来降低树的高度
 * 让查找一个元素的时间复杂度为O(lgn)
 * 但是现在不仅树的元素有大小，还有频率，每个元素出现的概率不一样
 * 希望概率高的路径短一些，构造一个最优搜索树。其整个树的期望代价最小。
 * 节点 ki(i=1,2,..n) ，标识一个树的节点，存在
 * pi 数组，标识，ki节点出现的概率
 * 节点 dj(i=1,2,,,n), 标识一个节点不在树中，标识没有该元素，找不到。
 * qj 数组，标识，di节点出现的概率
 * i == j-1, 标识，ki节点是一个叶子节点了，没有孩子节点，标识查找失败。
 * <p>
 * 计算一棵树的期望值
 * 由于一棵树所有节点的概率之和等于1即： p1+p2+...pn + q0+..gn = 1
 * 一个节点的期望价值，是找到这个节点的高度+1*qi
 * E(T) = (depth(ki) + 1)*pi(i=1,2..n) + depth(dj + 1)*qj(j=0,...n,n+1)
 * = depth(ki)*pi + 1*pi + depth(dj)+ 1 * qj  (i, j 都是范围，从1，。。n)
 * = depth(ki)*pi + depth(dj)*j + (qj + pi+qj)
 * = depth(ki)*pi + depth(dj)*j + 1
 * <p>
 * 1， 最优子结构
 * 把原问题的解，用其子问题的最优解进行求解，不断分解。
 * 这个看起来比较难处理，对于比较复杂的问题。我们先用假设法。
 * 假设存在最优二叉搜索树T，则其子树 T1 k(i..,j)， 一定也是最优的。
 * 如果子树T1不是最优的，存在更优子树T1' （同样的节点k(i,..j)
 * 那么存在比T更优的树T', 宇假设矛盾。一个最优树，其子树也一定是最优的。
 * 对于包含k个节点的子树 T1, k(i,..j)
 * k个节点如何构造一个最优树呢？
 * 二叉树搜索树结构是，一个根节点，一个左孩子，一个右孩子 ,左子树的节点值都小于等于根节点
 * 右孩子节点的值都大于、等于根节点。
 * 根据排序二叉树的特点，我们知道k个节点是有序的，只要知道了根节点，就可以知道左右孩子节点
 * 所以这里就便利所有的节点，作为根节点，然后找到期望值最小的根节点，就是我们的要找的最优二叉搜索树。
 * 2， 递归公式
 * expects[i][j] 存储节点，i到j的最优子树的最优值
 * // w(i, j) 标识 节点i，到j的概率之和
 * w(i, j) = pi + p(i+1) +... pj + q(i-1) + ...q(j)
 * <p>
 * // k是根节点，需要遍历所有的情况，找到最优的
 * // 把左右子树合并一个树的,左右子树的高度会加1，其期望值也要增加
 * // expect[i][k-1]  是左子树作为一棵树的时候计算的，现在要作为左子树，其所有节点高度要+1
 * // 即 E(left) = (depth(ki)+1+1)*pi + (depth(di)+1+1)*qi
 * = depth(ki)+2pi + depth(di)+2qi
 * = depth(ki) + pi + depth(qi) + qi + (pi+qi)
 * = expects[i][k-1] + w(i, k-1)
 * <p>
 * // 当前树的期望值 = 左孩子 + 右孩子 + 根节点
 * // 0 是根节点的高度，期望值是，高度+1 * 其概率
 * E[i,j] =  (expect[i][k-1] + w(i,k-1)) + (expect[k+1][j] + w(k+1，j)) + (0+1)* pk  (k从i到j)
 * = expects[i][k-1] + expect[k+1][j] + w(i, k-1) + pk + w(k+1, j)
 * // w(i, k-1) + pk + w(k+1, j) 就是所有节点的概率之和等于 w(i,j)
 * = expects[i][k-1] + expect[k+1][j] + w(i,j)
 * // 最优树公式
 * expects[i][j] = q(i-1), 当 j = i-1的时候 是一个孩子节点，标识查找的元素不存在,
 * // 比如， expects[1][0] 标识，存在一个d0 ，元素不存在
 * // 当i等于j时，证明子树只有一个节点，属于叶子节点，则存在两个不存在的元素di
 * expect[1][0] + expects[2][1]
 * expects[i][j] = Math.min( expects[i][k-1] + expect[k+1][j] + w(i,j))  (k从i到j, i <= j)
 * //
 * //
 * 3, 最优解的值计算，递归代码
 * 4， 输出最优路径
 */
public class OptimalBinarySearchTreeRecursive {

  /**
   * 这里是暴力解法, 穷举所有情况
   * 由于i，j之间存在, 每个子节点都存在两种情况，
   * 要么是根节点，要么是孩子节点，所以树的可能存在有 2^(n-1)
   * 但是对于暴力解法，所有重复的子问题，还需要重复计算所以其
   *
   * i 0，k=0 j = n
   * 0 0 1 n 0 1 3 n
   * @param p
   * @param q
   * @param ki
   * @param kj
   * @return
   */
  public static double solution(double[] p, double[] q, int ki, int kj) {
    if (ki == kj + 1) {
      return q[kj];
    }
    double expect = Double.MAX_VALUE;
    double wij = q[ki - 1];
    for (int i = ki; i <= kj; i++) {
      wij += (p[ki] + q[ki]);
    }
    for (int i = ki; i <= kj; i++) {
      double c = solution(p, q, ki, i - 1) + solution(p, q, i + 1, kj) + wij;
      if (expect > c) {
        expect = c;
      }
    }
    return expect;
  }
}
