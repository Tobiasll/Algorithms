package com.tobias.leetcode.linked_list;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct
 * numbers from the original list.
 *
 * Example 1:
 *
 * Input: 1->2->3->3->4->4->5 Output: 1->2->5 Example 2:
 *
 * Input: 1->1->1->2->3 Output: 2->3
 */
public class RemoveDuplicatesFromSortedListII82 {

  public ListNode deleteDuplicates(ListNode head) {
    ListNode result = new ListNode(0);
    ListNode root = head;
    ListNode resultNode = result;
    int temp = Integer.MAX_VALUE;
    int count = 0;
    while (root != null) {
      if (root.next == null || (root.next.val != root.val)) {
        if (root.val != temp) {
          resultNode.next = new ListNode(root.val);
          resultNode = resultNode.next;
        } else if (root.val == temp && count == 0) {
          resultNode.next = new ListNode(root.val);
          resultNode = resultNode.next;
        }
      } else if (root.next != null && root.next.val == root.val) {
        temp = root.val;
        count++;
      }
      root = root.next;
    }
    return result.next;
  }

  public static void main(String[] args) {
    RemoveDuplicatesFromSortedListII82 removeDuplicatesFromSortedListII82 = new RemoveDuplicatesFromSortedListII82();
    System.out.println(removeDuplicatesFromSortedListII82
        .deleteDuplicates(new ListNode(new int[]{1, 2, 3, 3, 4, 4, 5})));
    System.out.println(removeDuplicatesFromSortedListII82
        .deleteDuplicates(new ListNode(new int[]{-2147483648, 2147483647, 2})));
  }
}
