package com.tobias.rudiment.map;

public class LinkedListMap<K extends Comparable<K>, V> implements Map<K, V> {

  private class Node {
    K key;
    V value;
    Node next;

    Node(K key, V value, Node next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }

    Node(K key, V value){
      this(key, value, null);
    }

    Node(){
      this(null, null, null);
    }

    @Override
    public String toString() {
      return key.toString() + " : " + value.toString();
    }
  }

  private int size;
  private Node dummyHead;

  public LinkedListMap() {
    this.size = 0;
    this.dummyHead = new Node();
  }
  @Override
  public int getSize() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  private Node getNode(K key) {
    Node currentNode = dummyHead.next;
    while (currentNode != null) {
      if (currentNode.key.equals(key)) {
        return currentNode;
      }
      currentNode = currentNode.next;

    }
    return null;
  }


  @Override
  public void add(K key, V value) {

    Node node = getNode(key);

    if (node == null) {
      dummyHead.next = new Node(key, value, dummyHead.next);
      size++;
    } else {
        node.value = value;
    }

  }



  @Override
  public boolean contains(K key) {
    return getNode(key) != null;
  }

  @Override
  public V get(K key) {
    Node node = getNode(key);
    return node == null ? null : node.value;
  }

  @Override
  public void set(K key, V value) {
      add(key, value);
  }

  @Override
  public V remove(K key) {

    Node prev = dummyHead;
    while (prev.next != null) {
      if (prev.next.key.equals(key)) {
        break;
      }
      prev = prev.next;
    }

    if (prev.next != null ){
      Node delNode = prev.next;
      prev.next = delNode.next;
      delNode.next = null;
      size--;
      return delNode.value;
    }

    return null;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    Node currentNode = dummyHead.next;
    while (currentNode != null) {
      sb.append(currentNode.toString()).append("-->");
      currentNode = currentNode.next;
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    LinkedListMap<String, Integer> map = new LinkedListMap<>();
    System.out.println(map);
    map.add("sdas", 1);

    System.out.println(map);
    System.out.println(map.size);
    map.remove("sdas");
    System.out.println(map);
  }


}
