package tree;

import java.util.Objects;

/**
 * 二叉树后序遍历
 * 递归
 */
public class RecursivePostOrderBinaryTree {
  public static <T extends Comparable> void postOrder(BinaryTreeNode<T> root) {
    if (Objects.isNull(root)) {
      return ;
    }
    postOrder(root.getLeftChild());
    postOrder(root.getRightChild());
    System.out.println(root.getValue());
  }

}
