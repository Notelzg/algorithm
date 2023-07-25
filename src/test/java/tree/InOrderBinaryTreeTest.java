package tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InOrderBinaryTreeTest {

  @Test
  void order() {
    Integer[] t = new Integer[]{5,3,7,4,2,8};
    BinaryTreeNode<Integer> treeNode = BinaryTreeHelper.create(t);
    List<Integer> orderRs = InOrderBinaryTree.order(treeNode);
    Integer[] rsArr = orderRs.toArray(new Integer[]{});
    System.out.println(Arrays.toString(rsArr));
    Arrays.sort(t);
    Assertions.assertArrayEquals(t, rsArr);
  }
}