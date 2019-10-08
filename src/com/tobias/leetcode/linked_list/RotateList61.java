package com.tobias.leetcode.linked_list;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 *
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */
public class RotateList61 {


  /**
   * Time Limit Exceeded
   */
  public ListNode rotateRight1(ListNode head, int k) {

    ListNode root = head;
    int count = 0;
    while (root != null ) {
      root = root.next;
      count++;
    }

    k = k % count;

    if (head == null || count == 1) {
      return head;
    }

    for (int i = 0; i < k; i++) {
      head = handle(head);
    }
    return head;
  }

  private ListNode handle(ListNode head) {
    ListNode root = head;
    while (root != null && root.next != null && root.next.next != null) {
      root = root.next;
    }
    ListNode newHead = root.next;
    root.next = null;
    newHead.next = head;
    return newHead;
  }

  public static void main(String[] args) {
    RotateList61 rotateList61 = new RotateList61();
    System.out.println(rotateList61.rotateRight1(new ListNode(new int[]{1, 2, 3, 4, 5}), 2));
    System.out.println(rotateList61.rotateRight1(new ListNode(new int[]{0, 1, 2}), 4));
    System.out.println(rotateList61.rotateRight1(new ListNode(new int[]{1, 2}), 3));
  }

}
