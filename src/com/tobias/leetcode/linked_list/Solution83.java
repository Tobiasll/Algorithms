package com.tobias.leetcode.linked_list;

public class Solution83 {

  public static void main(String[] args) {
    System.out.println(deleteDuplicates(new ListNode(new int[]{1, 1, 1})));
  }

  private static ListNode deleteDuplicates(ListNode head) {

    ListNode cur = head;

    while (cur != null) {
      if (cur.next == null) {
        break;
      }
      if (cur.val == cur.next.val) {
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
      }
    }
    return head;
  }

}
