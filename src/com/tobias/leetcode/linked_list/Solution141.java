package com.tobias.leetcode.linked_list;

/**
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the
 * position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no
 * cycle in the linked list.
 *
 * Input: head = [3,2,0,-4], pos = 1 Output: true Explanation: There is a cycle in the linked list,
 * where tail connects to the second node.
 *
 * Input: head = [1,2], pos = 0 Output: true Explanation: There is a cycle in the linked list, where
 * tail connects to the first node.
 *
 * Input: head = [1], pos = -1 Output: false Explanation: There is no cycle in the linked list.
 */
public class Solution141 {

  public static void main(String[] args) {
    System.out.println(hasCycle(new ListNode(new int[]{3, 2, 0, -4})));
    System.out.println(hasCycle(new ListNode(new int[]{2, 1})));
  }

  private static boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
    }
    ListNode walker = head;
    ListNode runner = head;
    while (runner.next != null && runner.next.next != null) {
      walker = walker.next;
      runner = runner.next.next;
      if (walker == runner) {
        return true;
      }
    }
    return false;
  }

}
