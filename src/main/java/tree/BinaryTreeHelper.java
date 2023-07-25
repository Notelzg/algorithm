package tree;

import java.util.Objects;

public class BinaryTreeHelper {
  private BinaryTreeHelper() {
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
}
