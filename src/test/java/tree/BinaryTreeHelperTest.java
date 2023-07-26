package tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
class T{

}
public class BinaryTreeHelperTest {
  public BinaryTreeHelperTest() {
    super();
  }


    @Test
  public void t() {

    System.out.println(1 + 2 + "apple");
    System.out.println( "apple" + 1 + 2 );


    boolean rs = (double) 1.1 == (float) 1.1;
    System.out.println(rs);
//    System.out.printf("%s, %x, ", Double.doubleToLongBits(1.1), (float)1.1);
    System.out.println(Integer.toBinaryString(Float.floatToIntBits((float) 0.1)));
    System.out.println(Long.toBinaryString(Double.doubleToLongBits(0.1)));
    System.out.println(Long.toBinaryString(Double.doubleToLongBits((float)0.1)));
    System.out.println(Double.toHexString(1.1));

    System.out.println(Math.floor(3.9));
    System.out.println(Math.floor(-3.9));
  }

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