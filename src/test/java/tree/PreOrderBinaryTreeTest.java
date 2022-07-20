package tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PreOrderBinaryTreeTest {

  @Test
  void travel() {
    Integer[] t = new Integer[]{5,3,7,2,8};
    BinaryTreeNode<Integer> treeNode = BinaryTreeHelper.create(t);
    List<Integer> orderRs = PreOrderBinaryTree.travel(treeNode);
    Integer[] rsArr = orderRs.toArray(new Integer[]{});
    Integer[] expect = new Integer[]{5,3,2,7,8};
    Assertions.assertArrayEquals(expect, rsArr);
  }
}