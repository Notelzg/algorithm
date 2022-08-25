package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归后序遍历
 */
public class PostOrderBinaryTree {
  public static <T extends Comparable> List<T> travel(BinaryTreeNode<T> rootNode) {
    List<T> rs = new ArrayList<>();
    travel(rs, rootNode);
    return rs;
  }

  private static <T extends Comparable> void travel(List<T> rs, BinaryTreeNode<T> rootNode) {
    BinaryTreeNode<T> currentNode = rootNode;
    BinaryTreeNode<T> preNode = null;
    Stack<BinaryTreeNode<T>> stack = new Stack<>();
    while (null != currentNode || !stack.isEmpty()) {
      while (null != currentNode) {
        stack.push(currentNode);
        currentNode = currentNode.getLeftChild();
      }
      currentNode = stack.peek().getRightChild();
      if (null == currentNode || preNode == currentNode) {
        preNode = stack.pop();
//        System.out.println(preNode.getValue());
        rs.add(preNode.getValue());
        currentNode = null;
      }
    }
  }
}
