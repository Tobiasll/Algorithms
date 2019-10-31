package com.tobias.rudiment.map;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

  class Node {

    K key;
    V value;
    Node left;
    Node right;

    Node(K key, V value) {
      this.key = key;
      this.value = value;
      this.left = null;
      this.right = null;
    }

    @Override
    public String toString() {
      return key.toString() + " : " + value.toString();
    }
  }

  private Node root;
  private int size;

  public BSTMap(K key, V value) {
    root = new Node(key, value);
    size = 0;
  }

  public BSTMap() {
    root = null;
    size = 0;
  }

  private Node getNode(Node node, K key) {
    if (node == null) {
      return null;
    }

    if (node.key.equals(key)) {
      return node;
    } else if (node.key.compareTo(key) < 0) {
      return getNode(node.left, key);
    } else {
      return getNode(node.right, key);
    }
  }

  @Override
  public void add(K key, V value) {
    root = add(root, key, value);
  }


  private Node add(Node node, K key, V value) {
    if (node == null) {
      size++;
      return new Node(key, value);
    }
    if (key.compareTo(node.key) < 0) {
      node.left = add(node.left, key, value);
    } else if (key.compareTo(node.key) > 0) {
      node.right = add(node.right, key, value);
    } else {
      node.value = value;
    }

    return node;
  }

  @Override
  public boolean contains(K key) {
    return getNode(root, key) == null;
  }

  @Override
  public V get(K key) {
    Node node = getNode(root, key);
    return node != null ? node.value : null;
  }

  @Override
  public void set(K key, V value) {

  }

  @Override
  public V remove(K key) {
    return null;
  }

  @Override
  public int getSize() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }
}
