package com.tobias.rudiment.queue;

public class LinkedQueue<E> implements Queue<E> {

  private Node head, tail;
  private int size;

  public LinkedQueue() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  private class Node {

    E e;
    Node next;

    public Node(E e, Node next) {
      this.e = e;
      this.next = next;
    }

    public Node(E e) {
      this(e, null);
    }

    public Node() {
      this(null, null);
    }

    @Override
    public String toString() {
      return e.toString();
    }
  }

  @Override
  public int getSize() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return tail == null;
  }

  @Override
  public void enqueue(E e) {
    if (tail == null) {
      tail = new Node(e);
      head = tail;
    } else {
      tail.next = new Node(e);
      tail = tail.next;
    }
    size++;
  }

  @Override
  public E dequeue() {
    if (head == null) {
      throw new IllegalArgumentException("can`t be empty");

    }
    Node delNode = head;
    head = delNode.next;
    delNode.next = null;
    if(head == null)
      tail = null;
    size--;
    return delNode.e;
  }

  @Override
  public E getFront() {
    return head.e;
  }

  @Override
  public String toString() {

    StringBuilder res = new StringBuilder();

    Node cur = head;
    while (cur != null) {
      res.append(cur).append("->");
      cur = cur.next;
    }

    return res.toString();
  }

  public static void main(String[] args) {
    LinkedQueue<Integer> queue = new LinkedQueue<>();
    for (int i = 0; i < 10; i++) {
      queue.enqueue(i);
      System.out.println(queue);

      if (i % 3 == 2) {
        queue.dequeue();
        System.out.println(queue);
      }
    }
    System.out.println(queue.getFront());
  }
}
