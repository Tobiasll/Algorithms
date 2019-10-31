package com.tobias.cat;

import com.tobias.leetcode.linked_list.ListNode;

/**
 * 计算链表中有多少个节点.
 *
 * 样例 样例  1: 输入:  1->3->5->null 输出: 3
 *
 * 样例解释: 返回链表中结点个数，也就是链表的长度.
 *
 * 样例 2: 输入:  null 输出: 0
 *
 * 样例解释: 空链表长度为0
 */
public class Solution466 {

  public int countNodes(ListNode head) {
    // write your code here
    if (head == null) {
      return 0;
    }
    int count = 0;
    ListNode current = head;
    while (current != null) {
      count++;
      current = current.next;
    }
    return count;
  }

  public static void main(String[] args) {
    Solution466 solution466 = new Solution466();
    System.out.println(solution466.countNodes(new ListNode(new int[]{1, 3, 5})));
    System.out.println(solution466.countNodes(null));
  }
}
