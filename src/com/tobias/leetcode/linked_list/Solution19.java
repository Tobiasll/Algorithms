package com.tobias.leetcode.linked_list;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class Solution19 {

  public static void main(String[] args) {
    System.out.println(bestRemoveNthFromEnd(new ListNode(new int[]{1, 2, 3 ,4 ,5}) ,2));
  }

  private static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    int length = 0;
    ListNode first = head;

    while (first != null) {
      length++;
      first = first.next;
    }

    length -= n;
    first = dummy;

    while (length > 0) {
      length--;
      first = first.next;
    }

    first.next = first.next.next;
    return dummy.next;
  }


  private static ListNode bestRemoveNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy;
    ListNode second = dummy;
    for (int i = 0; i < n + 1; i++) {
      first = first.next;
    }

    while (first != null) {
      first = first.next;
      second = second.next;
    }

    second.next = second.next.next;
    return dummy.next;
  }

}
