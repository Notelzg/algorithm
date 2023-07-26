package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 */
public class LowestCommonAncestor<T extends Comparable> {
  /**
   * 1, 暴力解法，获取 p ， q 节点的所有的祖先路径，包含p q本身，放到数组中
   * 2, 因为数组中祖先的顺序是，第一个是 p ，q本身，最后一个是根节点，所以
   * 从后向前对比两个数组中，遇到相同的就记录下来，直到遇到不同的祖先，或者数组为空
   * 时间复杂度：O(log2^n)
   * 获取祖先节点，需要遍历二叉树，寻找节点，最大深度是树的深度，所以时间复杂度 2*log2^n)
   * 两个数组对比，数组最大长度就是数的深度 log2^n, 所以总的时间复杂度是 3*log2^n
   * 空间复杂度:  O(log2^n),  2个数组：2log2^n,
   *
   * @param root
   * @param p
   * @param q
   * @return
   */
  public BinaryTreeNode<T> lowestCommonAncestor(BinaryTreeNode<T> root, BinaryTreeNode<T> p, BinaryTreeNode<T> q) {
    List<BinaryTreeNode<T>> pAncestor = new ArrayList<>();
    List<BinaryTreeNode<T>> qAncestor = new ArrayList<>();
    getAncestor(root, p, pAncestor);
    getAncestor(root, q, qAncestor);
    BinaryTreeNode<T> ans = null;
    for (int i = 0; i < pAncestor.size() && i < qAncestor.size(); i++) {
      if (pAncestor.get(pAncestor.size() - i - 1).equals(qAncestor.get(qAncestor.size() - i - 1))) {
        ans = pAncestor.get(pAncestor.size() - i - 1);
      } else {
        return ans;
      }
    }
    return ans;
  }

  public boolean getAncestor(BinaryTreeNode<T> node, BinaryTreeNode<T> targetNode, List<BinaryTreeNode<T>> ancestorList) {
    if (Objects.isNull(node)) {
      return false;
    }

    if (node.equals(targetNode)) {
      ancestorList.add(node);
      return true;
    }

    if (getAncestor(node.getLeftChild(), targetNode, ancestorList) ||
            getAncestor(node.getRightChild(), targetNode, ancestorList)) {
      ancestorList.add(node);
      return true;
    }
    return false;
  }

  /**
   * 优化方案，因为时间复杂度已经是最优的，所以只能是空间复杂度
   * 把数组的对比，放到树的遍历中，当两个节点都找到的时候，也就是最近的祖先节点了，
   * 因为后续遍历，先遍历字节点，后遍历父亲节点, 的特点，会导致最底层的节点先被访问，上层后被访问，
   * 这个时候存在两种情况
   * 1. p 和 q 不属于同一个子树，这个时候处于低层的p 和 q的负节点，就是最近的公共父节点
   * 2. p 和 q属于同一个子树，p 或者 q本身就是最近的公共父节点
   *
   */
  public BinaryTreeNode<T> lowestCommonAncestorOpt(BinaryTreeNode<T> root, BinaryTreeNode<T> p, BinaryTreeNode<T> q) {
    if (Objects.isNull(root)) {
      return null;
    }
    Result result = new Result();
    lowestCommonAncestorOptAux(root, p, q, result);
    return result.root;
  }

  static class Result {
    BinaryTreeNode root;
  }


  public boolean lowestCommonAncestorOptAux(BinaryTreeNode<T> root, BinaryTreeNode<T> p, BinaryTreeNode<T> q, Result result) {
    if (Objects.isNull(root)) {
      return false;
    }

    boolean find = root.equals(p) || root.equals(q);
    boolean isLeft = lowestCommonAncestorOptAux(root.getLeftChild(), p, q, result);
    boolean isRight = lowestCommonAncestorOptAux(root.getRightChild(), p, q, result);
    System.out.printf("\nroot %s, find %s, isLeft %s, isRight %s", root, find, isLeft, isRight);
    if (isLeft && isRight ) {
      System.out.printf("\n -------> root %s, find %s, isLeft %s, isRight %s", root, find, isLeft, isRight);
      result.root = root;
      return false;
    }
    if ((isLeft || isRight) && find ) {
      result.root = root;
      return false;
    }
    return find || isLeft || isRight;
  }

}
