package dynamic.optimalbinarysearchtree;

import dynamic.matixmultiplay.Result;
import tree.BinaryTreeNode;
import tree.PostOrderBinaryTree;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 递归+备忘录
 * 复杂度 O(n^2)
 * 每个子问题，只需要求解一次
 * i，j 之间，总共存在n个子问题(去重之后），所以总共的子问空间有n个
 * 每个子问题最多需要计算n次，所以时间复杂度 O(n^2)
 */
public class OptimalBinarySearchTreeRecursiveMemorized {
  // 由于 double存在，精度丢失的问题，所以这里概率乘以100，转为整数
  public static Result solution(int[] p, int[] q, int i, int j) {
    int[][] expects = new int[q.length + 1][q.length + 1];
    int[][] wij = new int[q.length + 1][q.length + 1];
    int[][] root = new int[j + 1][j + 1];
    solutionAux(p, q, i, j, expects, wij, root);
    System.out.println();
    BinaryTreeNode<String> treeNode = postOrderTree(root, i, j, null);
    List<String> list = PostOrderBinaryTree.travel(treeNode);
    return new Result(expects[i][j], list.stream().collect(Collectors.joining(",")));
  }

  private static int solutionAux(int[] p, int[] q, int i, int j, int[][] expects, int[][] wij, int[][] root) {
    if (i == j + 1) {
      expects[i][j] = q[j];
      // 方法2，初始化
      wij[i][j] = q[i - 1];
      return expects[i][j];
    }
    if (expects[i][j] > 0.0d) {
      return expects[i][j];
    }
    expects[i][j] = Integer.MAX_VALUE;
    // 方法1，初始化
//    wij[i][j] = q[i - 1];
    for (int k = i; k <= j; k++) {
      // 方法1 ，每次重复计算子问题, wij可以延迟加上去，不影响最终结果
//      wij[i][j] += (p[k] + q[k]);
      int expect = solutionAux(p, q, i, k - 1, expects, wij, root) +
          solutionAux(p, q, k + 1, j, expects, wij, root);
      if (expects[i][j] > expect) {
        expects[i][j] = expect;
        root[i][j] = k;
      }
    }
    // 方法2 ， 递归之后走到这里的时候，子问题都已经计算好了，可以进行复用，避免重复计算
    wij[i][j] = wij[i][j - 1] + q[j] + p[j];
    //  由于 wij 的值，在循环中是不变的，所以可以最后加上去即可，可以保证结果的一致性
    expects[i][j] = expects[i][j] + wij[i][j];
    return expects[i][j];
  }

  public static BinaryTreeNode<String> postOrderTree(int[][] root, int i, int j, BinaryTreeNode<String> patent) {
    if (i == j + 1) {
//      System.out.printf("D%s, ", j);
      return new BinaryTreeNode<String>("D" + j, patent);
    }
    int r = root[i][j];
    BinaryTreeNode<String> current = new BinaryTreeNode<>("K"+r, patent) ;
    BinaryTreeNode<String> left = postOrderTree(root, i, r - 1, current);
    BinaryTreeNode<String> right = postOrderTree(root, r + 1, j, current);
    current.setLeftChild(left);
    current.setRightChild(right);
    System.out.printf("root: K%s, left:%s, right %s\n", r, left, right);
    return current;
  }

}
