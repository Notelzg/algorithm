package tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostOrderBinaryTreeTest {

  @Test
  void travel() {
    // 2 3 5 7 8
    Integer[] t = new Integer[]{5,3,7,2,8};
    BinaryTreeNode<Integer> treeNode = BinaryTreeHelper.create(t);
    List<Integer> orderRs = PostOrderBinaryTree.travel(treeNode);
    Integer[] rsArr = orderRs.toArray(new Integer[]{});
    Integer[] expect = new Integer[]{2, 3, 8, 7, 5};
    Assertions.assertArrayEquals(expect, rsArr);
  }
}