package tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
class BinaryTreeHelperTest {

  @Test
  void create() {
    Integer[] t = new Integer[]{5,3,7,2,8};
    BinaryTreeNode<Integer> treeNode = BinaryTreeHelper.create(t);
    List<Integer> orderRs = RecursiveInOrderBinaryTree.inOrder(treeNode);
    Integer[] rsArr = orderRs.toArray(new Integer[]{});
    Arrays.sort(t);
    Assertions.assertArrayEquals(t, rsArr);
  }

  @Test
  void create_null() {
    BinaryTreeNode<Integer> treeNode = BinaryTreeHelper.create(null);
    Assertions.assertNull(treeNode.getValue());
  }

  @Test
  void create_empty() {
    Integer[] t = new Integer[]{};
    BinaryTreeNode<Integer> treeNode = BinaryTreeHelper.create(t);
    Assertions.assertNull(treeNode.getValue());
  }
}