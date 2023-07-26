package tree;

import java.util.Comparator;
import java.util.Objects;

public class BinaryTreeNode<T extends Comparable> {
  private BinaryTreeNode<T> leftChild;
  private BinaryTreeNode<T> rightChild;
  private BinaryTreeNode<T> parent;
  private T value;

  public BinaryTreeNode(T value) {
    this.value = value;
  }

  public BinaryTreeNode(T value, BinaryTreeNode<T> parent) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BinaryTreeNode<?> that = (BinaryTreeNode<?>) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(leftChild, rightChild, parent, value);
  }
}
