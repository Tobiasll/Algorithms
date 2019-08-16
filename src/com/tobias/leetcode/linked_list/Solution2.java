package com.tobias.leetcode.linked_list;


/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807
 */
public class Solution2 {


  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int sum = 0;
    boolean carry = false;
    ListNode head = new ListNode(-1);
    ListNode ans = head;
    while (l1 != null || l2 != null) {
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }

      if (carry) {
        sum += 1;
      }

      if (sum >= 10) {
        carry = true;
      } else {
        carry = false;
      }
      head.next = new ListNode(sum % 10);
      head = head.next;
      sum = 0;
      if (l1 == null && l2 == null && carry) {
        head.next = new ListNode(1);
      }
    }
    return ans.next;
  }


  public static void main(String[] args) {
//    ListNode l1 = new ListNode(new int[]{2, 4, 3});
//    ListNode l2 = new ListNode(new int[]{5, 6, 4});
    ListNode l1 = new ListNode(new int[]{1, 8});
    ListNode l2 = new ListNode(0);
    Solution2 solution2 = new Solution2();
    ListNode result = solution2.addTwoNumbers(l1, l2);
    System.out.println(result);
  }
}
