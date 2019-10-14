package com.tobias.leetcode.linked_list;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 *
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseNodesinkGroup25 {

  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    ListNode subHead = head;
    ListNode toNull = head;
    dummy.next = head;
    ListNode tail = dummy;

    while (subHead != null) {
      int i = k;
      while (i - 1 > 0) {
        toNull = toNull.next;
        if (toNull == null) {
          return dummy.next;
        }
        i--;
      }
      ListNode temp = toNull.next;
      toNull.next = null;
      tail.next = reverse(subHead);
      tail = subHead;
      subHead = temp;
      toNull = subHead;
      tail.next = subHead;
    }
    return dummy.next;
  }

  private ListNode reverse(ListNode head) {
    ListNode currentListNode = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = currentListNode;
      currentListNode = head;
      head = next;
    }

    return currentListNode;
  }

  public static void main(String[] args) {
    ReverseNodesinkGroup25 reverseNodesinkGroup25 = new ReverseNodesinkGroup25();
    System.out.println(reverseNodesinkGroup25.reverseKGroup(new ListNode(new int[]{1, 2, 3, 4, 5}), 2));
  }

}
