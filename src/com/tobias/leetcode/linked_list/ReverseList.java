package com.tobias.leetcode.linked_list;


import java.util.Stack;


public class ReverseList {

  public static void main(String[] args) {
    ListNode listNode = new ListNode(new int[]{1, 2, 3, 4, 5});

    System.out.println(listNode);
    listNode = reverseListOne(listNode);
    System.out.println(listNode);
    listNode = reverseListTwo(listNode);
    System.out.println(listNode);
    System.out.println(reverseListThree(listNode));
  }

  private static ListNode reverseListOne(ListNode head) {

    ListNode cur = head;
    Stack<ListNode> stack = new Stack<>();
    while (cur != null) {
      stack.add(cur);
      cur = cur.next;
    }
    ListNode result = null;
    if (stack.size() > 0) {
      result = stack.pop();
    }
    cur = result;
    for (int i = stack.size(); i > 0; i--) {
      cur.next = stack.pop();
      cur = cur.next;
      cur.next = null;
    }
    return result;
  }

  private static ListNode reverseListTwo(ListNode head) {
    return getReverseListNode(head);
  }

  private static ListNode reverseListThree(ListNode head) {
    return reverseListInt(head, null);
  }

  private static ListNode reverseListInt(ListNode head, ListNode newHead) {
    if (head == null) {
      return newHead;
    }
    ListNode next = head.next;
    head.next = newHead;
    return reverseListInt(next, head);
  }

  static ListNode getReverseListNode(ListNode head) {
    ListNode prev = null;

    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }

    return prev;
  }

}
