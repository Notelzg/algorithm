package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归，先序遍历
 * @author logan92
 */
public class PreOrderBinaryTree {

  public static <T extends Comparable> List<T> travel(BinaryTreeNode<T> root) {
    List<T> rs = new ArrayList<>();
    travel(rs, root);
    return rs;
  }

  private static <T extends Comparable> void travel(List<T> rs, BinaryTreeNode<T> root) {
    BinaryTreeNode<T> currentNode = root;
    BinaryTreeNode<T>[] stack = new BinaryTreeNode[100];
    int top = -1;
    while(null != currentNode || top != -1) {
      while (null != currentNode) {
        rs.add(currentNode.getValue());
        stack[++top] = currentNode;
        currentNode = currentNode.getLeftChild();
      }
      currentNode = stack[top--].getRightChild();
    }
  }
}
