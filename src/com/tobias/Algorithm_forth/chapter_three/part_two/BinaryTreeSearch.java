package com.tobias.Algorithm_forth.chapter_three.part_two;

public class BinaryTreeSearch<K extends Comparable<K>, V> {

  private class Node {
    K key;
    V value;
    Node left;
    Node right;
    int size;

    public Node(K key, V value, int size) {
      this.key = key;
      this.value = value;
      this.size = size;
    }
  }

  private Node root;

  public int size() {
    return size(root);
  }

  private int size(Node root) {
    if (root == null) {
      return 0;
    }
    return size(root.left) + size(root.right);
  }


}
