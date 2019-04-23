package com.tobias.leetcode.linked_list;

public class MyLinkedList707 {

  private class Node {
    int val;
    Node next;

    public Node(int val, Node next) {
      this.val = val;
      this.next = next;
    }

    @Override
    public String toString() {
      return val + "";
    }
  }

  private int size;
  private Node head;

  /** Initialize your data structure here. */
  public MyLinkedList707() {
    head = new Node(0, null);
  }

  /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
  public int get(int index) {
    if (index < 0 | index >= size) {
      return -1;
    }
    Node cur = head.next;
    for (int i = 0; i < index; i++) {
      cur = cur.next;
    }
    return cur.val;
  }

  /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
  public void addAtHead(int val) {
    add(0, val);
  }

  private void add(int index, int val) {
    Node prev = head;
    for (int i = 0; i < index; i++) {
      prev = prev.next;
    }
    prev.next = new Node(val, prev.next);
    size++;
  }

  /** Append a node of value val to the last element of the linked list. */
  public void addAtTail(int val) {
    add(size, val);
  }

  /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
  public void addAtIndex(int index, int val) {
    if (index <= size && index >= 0) {
      add(index, val);
    } else if (index < 0) {
      add(size, val);
    }
  }

  /** Delete the index-th node in the linked list, if the index is valid. */
  public void deleteAtIndex(int index) {
    if (index >= 0 && index <= size) {
      Node cur = head;
      for (int i = 0; i < index; i++) {
        cur = cur.next;
      }
      Node del = cur.next;
      cur.next = del.next;
      size--;
    }

  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    Node cur = head.next;
    while (cur != null) {
      sb.append(cur.val).append("-->");
      cur = cur.next;
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    MyLinkedList707 linkedList = new MyLinkedList707();

    // ["MyLinkedList","addAtIndex","get","deleteAtIndex"]
    //[[],[-1,0],[0],[-1]]


    linkedList.addAtIndex(-1 ,0);
    System.out.println(linkedList.get(0));
    linkedList.deleteAtIndex(-1);


    System.out.println(linkedList);
  }

}
