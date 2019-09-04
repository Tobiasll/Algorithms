package com.tobias.Algorithm_forth.chapter_three.part_one;

public class SequenceFind<K extends Comparable<K>, V> {

  class Node {
    K key;
    V value;
    Node next;

    public Node(K key,V value, Node next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }

  private int size;
  private Node first;

  public boolean isEmpty() {
    return size == 0;
  }

  public int getSize() {
    return size;
  }

  public V get(K key) {
    if (isEmpty()) {
      return null;
    }
    Node current = first;
    while (current != null) {
      if (current.key.compareTo(key) == 0) {
        return current.value;
      }
      current = current.next;
    }
    return null;
  }

  public boolean put(K key, V value) {
    if (isEmpty()) {
      first = new Node(key, value, null);
    } else {
      Node current = first;
      while (current != null) {
        if (current.key.compareTo(key) == 0) {
          current.value = value;
          size++;
          return true;
        }
        current = current.next;
      }
      first = new Node(key, value, first);

    }
    size++;
    return true;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    Node current = first;
    while (current != null) {
      sb.append(current.key).append(" : ").append(current.value).append(", ");
      current = current.next;
    }
    return sb.toString().substring(0, sb.length() - 2);
  }

  public static void main(String[] args) {
    SequenceFind<Character, Integer> sequenceFind = new SequenceFind<>();
    sequenceFind.put('A', 1);
    sequenceFind.put('C', 3);
    sequenceFind.put('B', 2);
    sequenceFind.put('D', 4);
    System.out.println(sequenceFind);
    System.out.println(sequenceFind.get('A'));
    System.out.println(sequenceFind.get('F'));
  }

}
