package com.tobias.cat;

import com.tobias.leetcode.linked_list.ListNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 找链表的中点。
 *
 * 样例 样例 1:
 *
 * 输入:  1->2->3 输出: 2 样例解释: 返回中间节点的值 样例 2:
 *
 * 输入:  1->2 输出: 1 样例解释: 如果长度是偶数，则返回中间偏左的节点的值。 挑战 如果链表是一个数据流，你可以不重新遍历链表的情况下得到中点么？
 */
public class Solution228 {

  public ListNode middleNode(ListNode head) {
    // write your code here
    if (head == null) {
      return null;
    }
    List<Integer> list = new ArrayList<>();
    ListNode current = head;
    while (current != null) {
      list.add(current.val);
      current = current.next;
    }
    if (list.size() % 2 == 0) {
      return new ListNode(list.get(list.size() / 2 - 1));
    } else {
      return new ListNode(list.get(list.size() / 2));
    }
  }


  public static void main(String[] args) {
    Solution228 solution228 = new Solution228();
    System.out.println(solution228.middleNode(new ListNode(new int[]{1, 2, 3})));
    System.out.println(solution228.middleNode(new ListNode(new int[]{1, 2})));
  }
}
