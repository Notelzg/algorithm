package tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveInOrderBinaryTreeTest {

  @Test
  void inOrder() {
    Integer[] t = new Integer[]{5,3,7,2,8};
    BinaryTreeNode<Integer> treeNode = BinaryTreeHelper.create(t);
    List<Integer> orderRs = RecursiveInOrderBinaryTree.inOrder(treeNode);
    Integer[] rsArr = orderRs.toArray(new Integer[]{});
    Arrays.sort(t);
    Assertions.assertArrayEquals(t, rsArr);
  }
}