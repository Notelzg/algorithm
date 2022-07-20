package tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursivePostOrderBinaryTreeTest {

  @Test
  void postOrder() {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>();
    root.setValue(5);
    RecursivePostOrderBinaryTree.postOrder();
  }
}