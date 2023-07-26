package tree;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MifiTest {
  public static void main(String[] args) {
    Integer[] t = new Integer[]{5,3,7,4,2,8};
    BinaryTreeNode<Integer> treeNode = create(t);
    List<Integer> orderRs = order(treeNode);
    Integer[] rsArr = orderRs.toArray(new Integer[]{});
    System.out.println(Arrays.toString(rsArr));
    Arrays.sort(t);
    System.out.println(Arrays.equals(t, rsArr));
  }

  /**
   * @param rootNode
   * @return  返回中序的结果到list中
   */
  public static <T extends Comparable> List<T> order(BinaryTreeNode<T> rootNode) {
    // todo 具体实现
    return null;
  }


  public static <T extends Comparable> BinaryTreeNode<T> create(T[] arr) {
    if (null == arr || 0 == arr.length) {
      return new BinaryTreeNode<>(null);
    }
    BinaryTreeNode<T> root = new BinaryTreeNode<>(arr[0]);
    for (int i = 1; i < arr.length; i++) {
      insert(root, arr[i]);
    }
    return root;
  }

  private static <T extends Comparable> void insert(BinaryTreeNode<T> root, T t) {
    if (t.compareTo(root.getValue()) < 0) {
      // 如果存在，则进行递归
      if (Objects.nonNull(root.getLeftChild())) {
        insert(root.getLeftChild(), t);
        return;
      }
      // 不存在则插入
      BinaryTreeNode<T> child = new BinaryTreeNode<>(t, root);
      root.setLeftChild(child);
    } else {
      // 如果存在，则进行递归
      if (Objects.nonNull(root.getRightChild())) {
        insert(root.getRightChild(), t);
        return;
      }
      // 不存在则插入
      BinaryTreeNode<T> child = new BinaryTreeNode<>(t, root);
      root.setRightChild(child);
    }
  }

  public static class BinaryTreeNode<T extends Comparable> {
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;
    private BinaryTreeNode<T> parent;
    private T value;

    public BinaryTreeNode(T value) {
      this.value = value;
    }

    public BinaryTreeNode(T value,BinaryTreeNode<T> parent) {
      this.value = value;
      this.parent = parent;
    }

    public BinaryTreeNode<T> getLeftChild() {
      return leftChild;
    }

    public void setLeftChild(BinaryTreeNode<T> leftChild) {
      this.leftChild = leftChild;
    }

    public BinaryTreeNode<T> getRightChild() {
      return rightChild;
    }

    public void setRightChild(BinaryTreeNode<T> rightChild) {
      this.rightChild = rightChild;
    }

    public T getValue() {
      return value;
    }

    public void setValue(T value) {
      this.value = value;
    }

    public BinaryTreeNode<T> getParent() {
      return parent;
    }

    public void setParent(BinaryTreeNode<T> parent) {
      this.parent = parent;
    }

    @Override
    public String toString() {
      return "BinaryTreeNode{" +
              "value=" + value +
              '}';
    }
  }
}
