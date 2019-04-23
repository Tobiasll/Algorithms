package com.tobias.leetcode.linked_list;

/**
 *
 */
public class ReverseLinkedListII92 {

  public static void main(String[] args) {
    System.out.println(reverseBetween(new ListNode(new int[]{1, 2, 3, 4, 5}), 2, 4));
  }

  private static ListNode reverseBetween(ListNode head, int m, int n) {
    if (head == null) return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy;

    for (int i = 0; i < m; i++) {
      first = first.next;
    }

    ListNode start = first.next;
    ListNode later = start.next;

    for (int i = 0; i < n - m; i++) {
      start.next = later.next;
      later.next = first.next;
      first.next = later;
      later = start.next;
    }


    return dummy.next;
  }

}
