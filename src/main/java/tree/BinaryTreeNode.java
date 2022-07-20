package tree;

import java.util.Comparator;

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
}
