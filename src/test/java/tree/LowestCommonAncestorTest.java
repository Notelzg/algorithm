package tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LowestCommonAncestorTest {

  @Test
  public void lowestCommonAncestor() {
    LowestCommonAncestor<Integer> lowestCommonAncestor = new LowestCommonAncestor<>();
//    root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
    BinaryTreeNode<Integer> root = BinaryTreeHelper.create(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
    BinaryTreeNode<Integer> result = lowestCommonAncestor.lowestCommonAncestor(root, new BinaryTreeNode<Integer>(5), new BinaryTreeNode<Integer>(1));
    Assertions.assertEquals(result.getValue().intValue(), 3);

    /**
     * * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     *  * 输出：5
     *  * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
     */
    root = BinaryTreeHelper.create(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
    result = lowestCommonAncestor.lowestCommonAncestor(root, new BinaryTreeNode<Integer>(5), new BinaryTreeNode<Integer>(4));
    Assertions.assertEquals(result.getValue().intValue(), 5);

    /**
     *  * <p>
     *  * 输入：root = [1,2], p = 1, q = 2
     *  * 输出：1
     */
    root = BinaryTreeHelper.create(new Integer[]{1, 2});
    result = lowestCommonAncestor.lowestCommonAncestor(root, new BinaryTreeNode<Integer>(1), new BinaryTreeNode<Integer>(2));
    Assertions.assertEquals(result.getValue().intValue(), 1);
  }

  @Test
  public void lowestCommonAncestorOpt() {
    LowestCommonAncestor<Integer> lowestCommonAncestor = new LowestCommonAncestor<>();
//    root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
    BinaryTreeNode<Integer> root = BinaryTreeHelper.create(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
    BinaryTreeNode<Integer> result = lowestCommonAncestor.lowestCommonAncestorOpt(root, new BinaryTreeNode<Integer>(5), new BinaryTreeNode<Integer>(1));
    Assertions.assertEquals(result.getValue().intValue(), 3);

    /**
     * * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     *  * 输出：5
     *  * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
     */
    root = BinaryTreeHelper.create(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
    result = lowestCommonAncestor.lowestCommonAncestorOpt(root, new BinaryTreeNode<Integer>(5), new BinaryTreeNode<Integer>(4));
    Assertions.assertEquals(result.getValue().intValue(), 5);

    /**
     *  * <p>
     *  * 输入：root = [1,2], p = 1, q = 2
     *  * 输出：1
     */
    root = BinaryTreeHelper.create(new Integer[]{1, 2});
    result = lowestCommonAncestor.lowestCommonAncestorOpt(root, new BinaryTreeNode<Integer>(1), new BinaryTreeNode<Integer>(2));
    Assertions.assertEquals(result.getValue().intValue(), 1);
  }
}