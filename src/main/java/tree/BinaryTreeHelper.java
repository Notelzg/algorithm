package tree;

import java.util.Comparator;
import java.util.Objects;

public class BinaryTreeHelper {

  public static <T extends Comparable> BinaryTreeNode<T>  create(T[] arr) {
   BinaryTreeNode<T>  root = null;
    for (T t : arr) {
     if (Objects.isNull(root))  {
       root = new BinaryTreeNode<>(t);
       continue;
     }
     insert(root, t);
    }
    return root;
  }

  private static <T extends Comparable> void insert(BinaryTreeNode<T> root, T t) {
    if (root.getValue().compareTo(t) < 0) {
      // 如果存在，则进行递归
      if (Objects.nonNull(root.getLeftChild())) {
        insert(root.getLeftChild(), t);
      }
      // 不存在则插入
      BinaryTreeNode<T> child = new BinaryTreeNode<>(t, root);
      root.setLeftChild(child);
      return;
    } else {
      // 如果存在，则进行递归
      if (Objects.nonNull(root.getRightChild())) {
        insert(root.getRightChild(), t);
      }
      // 不存在则插入
      BinaryTreeNode<T> child = new BinaryTreeNode<>(t, root);
      root.setRightChild(child);
      return;
    }
  }


}
