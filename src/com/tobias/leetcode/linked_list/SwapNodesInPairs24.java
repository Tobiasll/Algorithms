package com.tobias.leetcode.linked_list;


/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNodesInPairs24 {


  public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode current = dummy;
    while (current.next != null && current.next.next != null) {
      ListNode swap1 = current.next;
      ListNode swap2 = current.next.next;
      current.next = swap2;
      swap1.next = swap2.next;
      swap2.next = swap1;
      current = current.next.next;
    }
    return dummy.next;
  }


  public ListNode swapPairsRecursion(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode n = head.next;
    head.next = swapPairsRecursion(head.next.next);
    n.next = head;
    return n;
  }


  public static void main(String[] args) {
    SwapNodesInPairs24 swapNodesInPairs24 = new SwapNodesInPairs24();
    System.out.println(swapNodesInPairs24.swapPairsRecursion(new ListNode(new int[]{1, 2, 3, 4})));
  }
}
