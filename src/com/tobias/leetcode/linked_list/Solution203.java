package com.tobias.leetcode.linked_list;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Input:  1->2->6->3->4->5->6, val = 6 Output: 1->2->3->4->5
 */
public class Solution203 {

  public static void main(String[] args) {
    System.out.println(removeElements(new ListNode(new int[]{6, 1, 2, 6, 3, 4, 5, 6}), 6));
    System.out.println(removeElements(new ListNode(new int[]{1}), 2));
    System.out.println(removeElements(new ListNode(new int[]{3, 1, 2, 2, 1}), 2));
    System.out.println(removeElements(new ListNode(new int[]{}), 1));

  }

  private ListNode removeElementsByRecursion(ListNode head, int val) {
    if (head == null) {
      return null;
    }
    head.next = removeElementsByRecursion(head.next, val);
    return head.val == val ? head.next : head;
  }

  private static ListNode removeElements(ListNode head, int val) {

    while (head.val == val) {
      head = head.next;
    }
    ListNode first = null;
    ListNode cur = head;
    while (cur != null) {
      if (cur.val == val) {
        ListNode delNode = first.next;
        first.next = delNode.next;
        cur = cur.next;
        continue;
      } else if (cur.next != null && cur.next.val == val) {
        ListNode delNode = cur.next;
        cur.next = delNode.next;
      }
      first = cur;
      cur = cur.next;
    }

    return head;
  }


}
