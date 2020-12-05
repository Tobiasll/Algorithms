package com.tobias.leetcode.linked_list;


import java.util.HashSet;
import java.util.Set;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the
 * position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no
 * cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 *
 *
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1 Output: tail connects to node index 1 Explanation: There is a
 * cycle in the linked list, where tail connects to the second node.
 *
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0 Output: tail connects to node index 0 Explanation: There is a cycle
 * in the linked list, where tail connects to the first node.
 *
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1 Output: no cycle Explanation: There is no cycle in the linked list.
 */
public class S_142LinkedListCycle {

  public ListNode detectCycleBySlowAndFastPoint(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    ListNode node;
    while (fast != null) {
      if (fast.next == null) {
        return null;
      }
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        node = fast;
        while (head != node) {
          head = head.next;
          node = node.next;
        }
        return head;
      }
    }
    return null;
  }


  public ListNode detectCycle(ListNode head) {
    Set<ListNode> set = new HashSet<>();
    while (head != null) {
      set.add(head);
      head = head.next;
      if (set.contains(head)) {
        return head;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    S_142LinkedListCycle linkedListCycle = new S_142LinkedListCycle();
    System.out.println(linkedListCycle.detectCycleBySlowAndFastPoint(new ListNode(new int[]{3, 2, 0, -4})));
  }
}
