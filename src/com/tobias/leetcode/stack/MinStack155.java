package com.tobias.leetcode.stack;


/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant
 * time.
 *
 * push(x) -- Push element x onto stack. pop() -- Removes the element on top of the stack. top() --
 * Get the top element. getMin() -- Retrieve the minimum element in the stack.
 *
 *
 * Example:
 *
 * MinStack minStack = new MinStack(); minStack.push(-2); minStack.push(0); minStack.push(-3);
 * minStack.getMin();   --> Returns -3. minStack.pop(); minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */

public class MinStack155 {

  private class Node {

    int value;
    Node prev;
    Node next;
    int min;

    Node(int value, Node prev, Node next, int min) {
      this(value, prev, next);
      this.min = min;
    }

    Node(int value, Node prev, Node next) {
      this.value = value;
      this.prev = prev;
      this.next = next;
    }
  }

  private Node head;
  private Node tail;
  private int size;
  private int min = Integer.MIN_VALUE;
  public int getSize() {
    return size;
  }

  public MinStack155() {

  }

  public void push(int x) {
    Node last = tail;
    Node newNode = new Node(x, last, null, tail != null ? Math.min(x, tail.min) : x);
    tail = newNode;
    if (last == null) {
      head = newNode;
    } else {
      last.next = newNode;
    }
    size++;
  }

  public void pop() {
    if (tail != null ) {
      if (tail.prev != null) {
        tail = tail.prev;
      } else {
        tail = null;
      }
      size--;
    }
  }

  public int top() {
    return tail.value;
  }

  public int getMin() {
    Node current = tail;
    int min = current.value;
    while (current != null) {
      min = Math.min(min, current.value);
      current = current.prev;
    }
    return min;
  }

  @Override
  public String toString() {
    Node current = tail;
    StringBuilder stringBuilder = new StringBuilder();
    while (current != null) {
      stringBuilder.append(current.value).append(" -> ");
      current = current.prev;
    }
    return stringBuilder.toString();
  }

  public static void main(String[] args) {
    //["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
    //[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
    MinStack155 minStack = new MinStack155();
    minStack.push(2147483646);
    minStack.push(2147483646);
    minStack.push(2147483647);
    System.out.println(minStack);
    System.out.println(minStack.top());
    minStack.pop();
    System.out.println(minStack);
    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack);
    minStack.push(2147483647);
    System.out.println(minStack.top());
    System.out.println(minStack.getMin());
    minStack.push(-2147483648);
    System.out.println(minStack.top());
    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.getMin());
    System.out.println(minStack);
  //[null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,-2147483648,null,2147483647]
  }
}
