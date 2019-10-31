package com.tobias.leetcode.linked_list;

import static com.tobias.leetcode.linked_list.ReverseList.getReverseListNode;

/**
 *
 */
public class Solution234 {

  public static void main(String[] args) {
    System.out.println(isPalindrome(new ListNode(new int[]{1, 2, 5, 6, 7, 8, 9})));
    System.out.println(isPalindrome(new ListNode(new int[]{1, 2, 2, 1})));
    System.out.println(isPalindrome(new ListNode(new int[]{1, 2, 3, 2, 1})));
  }

  private static boolean isPalindrome(ListNode head) {
    ListNode fast = head, slow = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    if (fast != null) {
      slow = slow.next;
    }

    slow = reverse(slow);
    fast = head;
    while (slow != null) {
      if (slow.val != fast.val) {
        return false;
      }
      slow = slow.next;
      fast = fast.next;
    }
    return true;
  }

  private static ListNode reverse(ListNode head) {
    return getReverseListNode(head);
  }


}
