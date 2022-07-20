package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归中序遍历
 */
public class InOrderBinaryTree {
  public static <T extends Comparable> List<T> order(BinaryTreeNode<T> rootNode) {
    List<T> rs = new ArrayList<>();
    order(rs, rootNode);
    return rs;
  }

  private static <T extends Comparable> void order(List<T> rs, BinaryTreeNode<T> rootNode) {
    BinaryTreeNode<T> currentNode = rootNode;
    Stack<BinaryTreeNode<T>> stack = new Stack<>();
    while (null != currentNode || !stack.isEmpty()) {
      while (null != currentNode) {
        stack.push(currentNode);
        currentNode = currentNode.getLeftChild();
      }
      currentNode = stack.pop();
      rs.add(currentNode.getValue());
      currentNode = currentNode.getRightChild();
    }
  }
}
