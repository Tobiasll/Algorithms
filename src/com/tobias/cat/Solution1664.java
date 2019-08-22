package com.tobias.cat;

import com.tobias.leetcode.linked_list.ListNode;

/**
 * 计算一个链表中值为非负奇数的节点的个数。
 *
 * 样例
 * 样例 1：
 *
 * 输入：1->3->5->null
 * 输出：3
 * 样例 2：
 *
 * 输入：0->null
 * 输出：0
 */
public class Solution1664 {

  public int countNodesII(ListNode head) {
    //
    if (head == null) {
      return 0;
    }
    ListNode current = head;
    int count = 0;
    while (current != null) {
      if (current.val > 0 && current.val % 2 != 0) {
        count++;
      }
      current = current.next;
    }
    return count;
  }

  public static void main(String[] args) {

  }
}
