package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 二叉树后序遍历
 * 递归
 */
public class RecursiveInOrderBinaryTree {
  public static <T extends Comparable> List<T> inOrder(BinaryTreeNode<T> root) {
    List<T> rs = new ArrayList<T>();
    inOrder(rs, root);
    return rs;
  }

  private static <T extends Comparable> void inOrder(List<T> rs, BinaryTreeNode<T> root) {
    if (Objects.isNull(root)) {
      return;
    }
    inOrder(rs, root.getLeftChild());
    rs.add(root.getValue());
    inOrder(rs, root.getRightChild());
  }

}
